package com.Proyecto.service;

import java.util.Optional;

import com.Proyecto.model.Usuario;

public interface UsuarioService {
    Optional<Usuario> findById(Integer id);
;
}
