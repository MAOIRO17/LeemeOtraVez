package com.Proyecto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Compra> getAll() {
        return compraRepository.findAll();
    }

    public String GenerarNumCompra() {
        int num = 0;
        String numConc = "";
        List<Compra> compras = compraRepository.findAll();
        List<Integer> numeros = new ArrayList<Integer>();
        compras.stream().forEach((c -> numeros.add(Integer.parseInt(c.getNumCompra()))));
        if (compras.isEmpty()) {
            numConc = "1";
        } else {
            num = numeros.stream().max(Integer::compare).get();
            num++;
        }
        if (num < 10) {
            numConc = "000000000" + String.valueOf(num);
        } else if (num < 100) {
            numConc = "00000000" + String.valueOf(num);
        } else if (num < 1000) {
            numConc = "0000000" + String.valueOf(num);
        }

        return numConc;
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
