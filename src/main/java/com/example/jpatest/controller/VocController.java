package com.example.jpatest.controller;

import com.example.jpatest.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class VocController {

    private final VocService vocService;

    @GetMapping("/voc/new")
    public String insertForm(Model model) {
        model.addAttribute("vocForm", new VocForm());
        return "voc/insertVocForm";
    }
}
