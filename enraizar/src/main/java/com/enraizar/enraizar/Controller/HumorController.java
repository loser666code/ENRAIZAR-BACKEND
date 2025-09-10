package com.enraizar.enraizar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HumorController {
    @GetMapping("/humor")
    public String humorPage(Model model){
        return "humor";
    }
}
