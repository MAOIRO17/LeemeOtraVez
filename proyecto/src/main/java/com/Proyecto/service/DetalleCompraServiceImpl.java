package com.Proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.Proyecto.Repository.DetalleCompraRepository;
import com.Proyecto.model.DetalleCompra;

public class DetalleCompraServiceImpl implements DetalleCompraService {
    @Autowired
private DetalleCompraRepository detalleCompraRepository;
    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

}
