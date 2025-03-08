package com.Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error/403")
    public String error403(Model model) {
        model.addAttribute("mensaje", "No tienes permiso para acceder.");
        model.addAttribute("redirectUrl", "/usuario/login");
        return "error/forbidden";
    }
}
