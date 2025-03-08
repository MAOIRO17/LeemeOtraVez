package com.Proyecto.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Proyecto.model.Compra;
import com.Proyecto.model.DetalleCompra;
import com.Proyecto.model.Libro;
import com.Proyecto.model.Usuario;
import com.Proyecto.service.CompraService;
import com.Proyecto.service.DetalleCompraService;
import com.Proyecto.service.LibrosService;
import com.Proyecto.service.UsuarioService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private LibrosService librosService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CompraService compraService;
    @Autowired
    private DetalleCompraService detalleCompraService;
    List<DetalleCompra> detallesCompra = new ArrayList<DetalleCompra>();
    Compra compra = new Compra();

    @GetMapping("")
    public String home(Model model,HttpSession session) {
        model.addAttribute("libros", librosService.getAll());
        model.addAttribute("sesion", session.getAttribute("usuario"));
        return "usuario/homeUsuario";

    }

    @GetMapping("/libroshome/{id}")
    public String LibrosHome(@PathVariable Integer id, Model model) {
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
        libro = libroOptional.get();
        detalleCompra.setCantidad(cantidad);
        detalleCompra.setPrecio(libro.getPrecio());
        detalleCompra.setTitulo(libro.getTitulo());
        detalleCompra.setPrecioTotal(libro.getPrecio() * cantidad);
        detalleCompra.setLibro(libro);
        Integer idLibro = libro.getId();
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

    @GetMapping("/carro")
    public String carro(Model model, HttpSession session) {
        model.addAttribute("carro", detallesCompra);
        model.addAttribute("compra", compra);
        model.addAttribute("session", session.getAttribute("usuario"));
        return "/usuario/carro";
    }

    @GetMapping("/ResumenCompra")
    public String ResumenCompra(Model model, HttpSession session) {
        Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("usuario").toString().toString())
        ).get();

        model.addAttribute("carro", detallesCompra);
        model.addAttribute("compra", compra);
        model.addAttribute("usuario", usuario);
        return "/usuario/ResumenCompra";
    }
    @GetMapping("/saveCompra")
    public String saveCompra(HttpSession session){
        Date fecha = new Date();
        compra.setFecha(fecha);
        compra.setNumCompra(compraService.GenerarNumCompra());
        Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("usuario").toString().toString())).get();
        compra.setUsuario(usuario);  
        compraService.save(compra);
        for (DetalleCompra detalle : detallesCompra) {
            detalle.setCompra(compra);
            detalleCompraService.save(detalle);
        }
        compra = new Compra();
        detallesCompra.clear();
        return "redirect:/";
    
    }
    @PostMapping("/buscar")
    public String buscarLibro(@RequestParam String titulo, Model model) {
        List<Libro> libros = librosService.getAll().stream().filter(l -> l.getTitulo().contains(titulo))
                .collect(Collectors.toList());
        model.addAttribute("libros", libros);
        return "usuario/homeUsuario";
    }
}
    

