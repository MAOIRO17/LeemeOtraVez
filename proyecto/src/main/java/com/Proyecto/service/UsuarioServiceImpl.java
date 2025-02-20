package com.Proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.Repository.UsuarioRepository;
import com.Proyecto.model.Usuario;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    
}