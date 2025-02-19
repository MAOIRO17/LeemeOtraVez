package com.Proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyecto.Repository.CompraRepository;
import com.Proyecto.model.Compra;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra save(Compra compra) {
       return compraRepository.save(compra);
    }

}
