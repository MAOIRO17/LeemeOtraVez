package com.Proyecto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.model.Libros;
import com.Proyecto.model.Usuario;
import com.Proyecto.service.LibrosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/libros")
public class LibrosController {
    private final Logger LOGGER= LoggerFactory.getLogger(LibrosController.class);
    @Autowired
    private LibrosService librosService;
    @GetMapping("")
    public String MostrarLibros(Model model) {
        model.addAttribute("libros", librosService.getAll());
        return "libros/MostrarLibros";
    }

    @GetMapping("/crear")
    public String CrearLibros() {
        return "libros/CrearLibros";
    }
    @PostMapping("/save")
    public String save(Libros libro) {
        LOGGER.info("Libro a editar: "+libro);
        Usuario usuario = new Usuario(49333225L,"","","","",null,null);
        libro.setUsuario(usuario);
        librosService.save(libro);
        return "redirect:/libros";
    }
}
