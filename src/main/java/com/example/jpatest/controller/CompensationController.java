package com.example.jpatest.controller;

import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.Order;
import com.example.jpatest.domain.Voc;
import com.example.jpatest.service.CompensationService;
import com.example.jpatest.service.OrderService;
import com.example.jpatest.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CompensationController {

    private final CompensationService compensationService;
    private final VocService vocService;
    private final OrderService orderService;

    @GetMapping("/compensation")
    public String insertForm(Model model) {

        List<Voc> vocList = vocService.findVocList();
        List<Order> orderList = orderService.findOrderList();

        model.addAttribute("vocList", vocList);
        model.addAttribute("orderList", orderList);

        return "compensation/insertCompensationForm";
    }

    @PostMapping("/compensation")
    public String compensation(@RequestParam("vocSeq") Long vocSeq,
                               @RequestParam("orderSeq") Long orderSeq,
                               @RequestParam("count") int count) {

        compensationService.compensation(vocSeq, orderSeq, count);
        return "redirect:/compensationList";
    }

    @GetMapping("/compensationList")
    public String list(Model model) {
        List<Compensation> compensations = compensationService.findCompensationList();
        model.addAttribute("compensations", compensations);
        return "compensation/compensationList";
    }

}
