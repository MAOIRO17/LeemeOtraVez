package com.Proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.model.Usuario;
import com.Proyecto.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

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
}
