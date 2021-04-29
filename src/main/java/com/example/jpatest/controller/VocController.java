package com.example.jpatest.controller;

import com.example.jpatest.domain.Voc;
import com.example.jpatest.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VocController {

    private final VocService vocService;

    @GetMapping("/voc/new")
    public String insertForm(Model model) {
        model.addAttribute("vocForm", new VocForm());
        return "voc/insertVocForm";
    }

    @PostMapping("/voc/new")
    public String insert(VocForm form) {


        Voc voc = new Voc();
        voc.setVocResponsibility(form.getVocResponsibility());
        voc.setVocNote(form.getVocNote());
        voc.setSellerCost(form.getSellerCost());
        voc.setManufacturingCost(form.getManufacturingCost());
        voc.setDeliveryCost(form.getDeliveryCost());
        voc.setCompensateExpense(form.getCompensateExpense());

        vocService.insert(voc);
        return "redirect:/";
    }

    @GetMapping("/vocList")
    public String list(Model model) {
        List<Voc> vocList = vocService.findVocList();
        model.addAttribute("vocList", vocList);
        return "voc/vocList";
    }
}
