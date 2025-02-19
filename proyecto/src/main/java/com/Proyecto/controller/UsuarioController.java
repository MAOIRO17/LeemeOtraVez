package com.Proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Proyecto.model.Usuario;
import com.Proyecto.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/registroUsuario")
    public String registroUsuario(){
        return "/usuario/registroUsuario";
    }
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuario){
        usuario.setTipo("USUARIO");
        usuarioService.save(usuario);
        return "redirect:/";
    }
     @GetMapping("/login")
    public String login(){
        return "/usuario/loginUsuario";    
}}
