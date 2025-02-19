package com.Proyecto.controller;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.Proyecto.model.Libro;
import com.Proyecto.model.Usuario;
import com.Proyecto.service.LibrosService;
import com.Proyecto.service.UploadFiles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/libros")
public class LibrosController {
    private final Logger LOGGER = LoggerFactory.getLogger(LibrosController.class);
    @Autowired
    private LibrosService librosService;
    @Autowired
    private UploadFiles uploadFiles;

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
    public String save(Libro libro, @RequestParam("img") MultipartFile file) throws IOException {
        Usuario usuario = new Usuario(1, "", "", "", "", "", null, null);
        libro.setUsuario(usuario);
        //
        if (libro.getId()==null) {
            String nombreImg = uploadFiles.saveImg(file);
            libro.setImagen(nombreImg);
        } else {
        }
        librosService.save(libro);
        return "redirect:/libros";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Libro libro = new Libro();
        Optional<Libro> optional = librosService.get(id);
        libro = optional.get();
        LOGGER.info("Libro a editar: " + libro);
        model.addAttribute("libro", libro);
        return "libros/EditarLibros";
    }

    @PostMapping("/update")
    public String update(Libro libro, @RequestParam("img") MultipartFile file) throws IOException {
        Libro l = new Libro();
        l = librosService.get(libro.getId()).get();
        if (file.isEmpty()) {
            libro.setImagen(l.getImagen());
        } else {
            if (!l.getImagen().equals("default.jpg")) {
                uploadFiles.deleteImg(l.getImagen());
            }
            String nombreImg = uploadFiles.saveImg(file);
            libro.setImagen(nombreImg);
        }
        libro.setUsuario(l.getUsuario());
        librosService.update(libro);
        return "redirect:/libros";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) throws IOException {
        Libro l = new Libro();
        l = librosService.get(id).get();
        if (!l.getImagen().equals("default.jpg")) {
            uploadFiles.deleteImg(l.getImagen());

        }
        librosService.delete(id);
        return "redirect:/libros";
    }
}
