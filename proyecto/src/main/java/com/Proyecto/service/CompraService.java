package com.Proyecto.service;

import org.springframework.stereotype.Service;

import com.Proyecto.model.Compra;

@Service
public interface CompraService {
    Compra save(Compra compra);

}
