package com.enraizar.enraizar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("message","bem-vindo ao enraizar!");
        return "home";
    }
}
