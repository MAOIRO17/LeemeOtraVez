package com.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.service.LibrosService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private LibrosService librosService;
    @GetMapping("")
public String home(Model model) {
    model.addAttribute("libros", librosService.getAll());
    return "usuario/home";
    
}}
