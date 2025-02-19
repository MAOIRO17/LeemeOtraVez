package com.Proyecto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Proyecto.model.Compra;
import com.Proyecto.model.DetalleCompra;
import com.Proyecto.model.Libro;
import com.Proyecto.service.LibrosService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private LibrosService librosService;
    List<DetalleCompra> detallesCompra = new ArrayList<DetalleCompra>();
    Compra compra = new Compra();

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("libros", librosService.getAll());
        return "usuario/homeUsuario";

    }

    @GetMapping("/libroshome/{id}")
    public String LibrosHome(@PathVariable Integer id, Model model) {
        log.info("id: " + id);
        Libro libro = new Libro();
        Optional<Libro> libroOptional = librosService.get(id);
        libro = libroOptional.get();
        model.addAttribute("libro", libro);
        return "usuario/LibrosHome";
    }

    @PostMapping("/carro")
    public String añadirCarro(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
        DetalleCompra detalleCompra = new DetalleCompra();
        Libro libro = new Libro();
        double sumaTotal = 0;
        Optional<Libro> libroOptional = librosService.get(id);
        log.info("libro añadido al carro : {}" + libroOptional.get());
        log.info("cantidad: {}" + cantidad);
        libro = libroOptional.get();
        detalleCompra.setCantidad(cantidad);
        detalleCompra.setPrecio(libro.getPrecio());
        detalleCompra.setTitulo(libro.getTitulo());
        detalleCompra.setPrecioTotal(libro.getPrecio() * cantidad);
        detalleCompra.setLibro(libro);
        Integer idLibro=libro.getId();
        boolean existe = detallesCompra.stream().anyMatch(l -> l.getLibro().getId() == idLibro);
        if (!existe) {
            detallesCompra.add(detalleCompra);        
        }
        
        sumaTotal = detallesCompra.stream().mapToDouble(dt -> dt.getPrecioTotal()).sum();

        compra.setPrecioTotal(sumaTotal);
        model.addAttribute("carro", detallesCompra);
        model.addAttribute("compra", compra);
        return "/usuario/carro";
    }

    @GetMapping("/delete/carro/{id}")
    public String deleteLibroCarro(@PathVariable Integer id, Model model) {
        List<DetalleCompra> compraNueva = new ArrayList<DetalleCompra>();
        for (DetalleCompra detalleCompra : detallesCompra) {
            if (detalleCompra.getLibro().getId() != id) {
                compraNueva.add(detalleCompra);
            }
        }
        detallesCompra = compraNueva;
        double sumaTotal = 0;
        sumaTotal = detallesCompra.stream().mapToDouble(dt -> dt.getPrecioTotal()).sum();
        compra.setPrecioTotal(sumaTotal);
        model.addAttribute("carro", detallesCompra);
        model.addAttribute("compra", compra);
        return "/usuario/carro";
    }
    @GetMapping("/getCarro")
    public String getCarro(Model model) {
        model.addAttribute("carro", detallesCompra);
        model.addAttribute("compra", compra);
        return "/usuario/carro";
    }
}
