package com.Practica01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jordy
 */
@Controller
public class IndexController {
    
    @GetMapping("/")
    public String inicio(Model model){
        model.addAttribute("variable", "Hola a todos desde el controller");
        model.addAttribute("edad", 25);
        return "index";
    }
    
}
