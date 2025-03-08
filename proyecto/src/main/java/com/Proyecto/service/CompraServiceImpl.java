package com.Proyecto.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.Repository.CompraRepository;
import com.Proyecto.model.Compra;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> getAll() {
        return compraRepository.findAll();
    }

    @Override
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }
@Override
public String GenerarNumCompra() {
    return String.valueOf(new Random().nextInt(900) + 100);
}

    @Override
    public List<Compra> findByUsuarioId(Integer usuario) {
        return compraRepository.findByUsuarioId(usuario);
    }

    @Override
    public Optional<Compra> findById(Integer id) {
        return compraRepository.findById(id);
    }
}
