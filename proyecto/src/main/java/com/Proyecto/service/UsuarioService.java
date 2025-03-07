package com.Proyecto.service;

import java.util.List;
import java.util.Optional;

import com.Proyecto.model.Usuario;

public interface UsuarioService {
    Optional<Usuario> findById(Integer id);
    Usuario save(Usuario usuario);
    Optional<Usuario> findByEmail(String email);
    List<Usuario> getAll();
;
}
