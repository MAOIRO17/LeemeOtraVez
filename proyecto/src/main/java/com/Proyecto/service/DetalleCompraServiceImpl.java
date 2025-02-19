package com.Proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.Repository.DetalleCompraRepository;
import com.Proyecto.model.DetalleCompra;
@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {
    @Autowired
private DetalleCompraRepository detalleCompraRepository;
    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

}
