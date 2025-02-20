package com.Proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Proyecto.model.Compra;

@Service
public interface CompraService {
    List<Compra> getAll();
    Compra save(Compra compra);
    String GenerarNumCompra();
    List<Compra> findByUsuarioId(Integer usuario);
    Optional<Compra> findById(Integer id);

}
