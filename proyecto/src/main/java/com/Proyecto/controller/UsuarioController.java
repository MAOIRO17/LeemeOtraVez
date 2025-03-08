package com.Proyecto.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.model.Compra;
import com.Proyecto.model.Usuario;
import com.Proyecto.service.CompraService;
import com.Proyecto.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CompraService compraService;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/registroUsuario")
    public String registroUsuario() {
        return "/usuario/registroUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario) {
        usuario.setTipo("USUARIO");
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioService.save(usuario);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "usuario/login";
    }

    @GetMapping("/acceder")
    public String acceder(Usuario usuario, HttpSession session) {
        Optional<Usuario> user = usuarioService
                .findById(Integer.parseInt(session.getAttribute("idusuario").toString()));
        if (user.isPresent()) {
            session.setAttribute("idusuario", user.get().getId());

            if (user.get().getTipo().equals("ADMIN")) {
                return "redirect:/admin";
            } else {
                return "redirect:/";
            }
        }

        return "redirect:/";

    }

    @GetMapping("/compras")
    public String compras(HttpSession session, Model model) {
        model.addAttribute("sesion", session.getAttribute("idusuario"));

        Usuario usuario = usuarioService.findById(Integer.parseInt(session.getAttribute("idusuario").toString())).get();
        List<Compra> compras = compraService.findByUsuarioId(usuario.getId());

        model.addAttribute("compras",compras);

        return "usuario/compras";
    }

    @GetMapping("/detalles/{id}")
    public String detallesCompra(@PathVariable Integer id, Model model, HttpSession session) {
        Optional<Compra> compra = compraService.findById(id);
        if (compra.isPresent()) {
            model.addAttribute("detalles", compra.get().getDetalleCompra());
        }

        model.addAttribute("sesion", session.getAttribute("idusuario"));
        return "/usuario/DetallesCompras";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("idusuario");
        return "redirect:/";
    }
}
