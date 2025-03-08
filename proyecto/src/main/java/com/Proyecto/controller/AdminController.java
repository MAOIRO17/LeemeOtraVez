package com.Proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.model.Compra;
import com.Proyecto.model.Libro;
import com.Proyecto.service.CompraService;
import com.Proyecto.service.LibrosService;
import com.Proyecto.service.UsuarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LibrosService librosService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CompraService compraService;

    @GetMapping("")
    public String PagPrincipal(Model model) {
        List<Libro> libros = librosService.getAll();
        model.addAttribute("libros", libros);
        return "admin/PagPrincipal";
    }

    @GetMapping("/usuarios")
    public String Usuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.getAll());
        return "admin/usuarios";
    }

    @GetMapping("/compras")
    public String Compras(Model model) {
        model.addAttribute("compras", compraService.getAll());
        return "admin/Compras";
    }

    @GetMapping("/detalles/{id}")
    public String Detalles(Model model, @PathVariable Integer id) {
        Compra compra = compraService.findById(id).get();
        model.addAttribute("detalles", compra.getDetalleCompra());
        return "admin/DetallesCompras";
    }
}
