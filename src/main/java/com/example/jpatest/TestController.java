package com.example.jpatest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("test")
    public String Test(Model model) {
        model.addAttribute("data", "test");
        return "test";
    }
}
