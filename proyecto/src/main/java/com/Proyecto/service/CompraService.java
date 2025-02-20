package com.Proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Proyecto.model.Compra;

@Service
public interface CompraService {
    List<Compra> findAll();
    Compra save(Compra compra);
    String GenerarNumCompra();
    List<Compra> findByUsuarioId(Integer usuario);
}
