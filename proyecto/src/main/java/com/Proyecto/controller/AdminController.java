package com.Proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.model.Libro;
import com.Proyecto.service.LibrosService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
@Autowired
private LibrosService librosService;
    @GetMapping("")
    public String PagPrincipal(Model model) {
        List<Libro> libros = librosService.getAll();
        model.addAttribute("libros", libros);
        return "admin/PagPrincipal";
    }
}
