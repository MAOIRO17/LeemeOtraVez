package com.Proyecto.service;

import org.springframework.stereotype.Service;

import com.Proyecto.model.DetalleCompra;

@Service
public interface DetalleCompraService {
    DetalleCompra save(DetalleCompra detalleCompra);

}
