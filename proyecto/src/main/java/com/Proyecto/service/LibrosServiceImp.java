package com.Proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyecto.model.Libros;
import com.Proyecto.repository.LibrosRepository;

@Service
public class LibrosServiceImp implements LibrosService {
    @Autowired
    private LibrosRepository librosRepository;

    @Override
    public Libros save(Libros libro) {
        return librosRepository.save(libro);
    }

    @Override
    public void update(Libros libro) {
        librosRepository.save(libro);
    }

    @Override
    public void delete(Integer id) {
        librosRepository.deleteById(id);
    }

    @Override
    public Optional<Libros> get(Integer id) {
        return librosRepository.findById(id);
    }

    @Override
    public List<Libros> getAll() {
        return librosRepository.findAll();
    }

}
