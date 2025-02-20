package com.Proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.model.Compra;
import com.Proyecto.model.Usuario;
import com.Proyecto.service.CompraService;
import com.Proyecto.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private CompraService compraService;

    @GetMapping("/registroUsuario")
    public String registroUsuario() {
        return "/usuario/registroUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario) {
        usuario.setTipo("USUARIO");
        usuarioService.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "/usuario/loginUsuario";
    }

    @PostMapping("/acceder")
    public String acceder(Usuario usuario, HttpSession session) {
        Optional<Usuario> usuarioBD = usuarioService.findByEmail(usuario.getEmail());
        if (usuarioBD.isPresent()) {
            session.setAttribute("usuario", usuarioBD.get().getId());
            if (usuarioBD.get().getTipo().equals("ADMIN")) {
                return "redirect:/admin";
            } else {
                return "redirect:/";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/compras")
    public String compras(HttpSession session, Model model) {
        model.addAttribute("session", session.getAttribute("usuario"));
        Usuario usuario = usuarioService.findById((Integer) session.getAttribute("usuario")).get();
        List<Compra> compras = compraService.findByUsuarioId(usuario.getId());
        model.addAttribute("compras", compras);
        return "/usuario/compras";
    }

    @GetMapping("/detalles/{id}")
    public String detallesCompra(@PathVariable Integer id, Model model, HttpSession session) {
        Optional<Compra> compra = compraService.findById(id);
        model.addAttribute("detalles", compra.get().getDetalleCompra());
        model.addAttribute("session", session.getAttribute("usuario"));
        return "/usuario/DetallesCompras";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("usuario");
        return "redirect:/";
    }
}
