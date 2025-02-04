package com.Proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Proyecto.model.Libro;
import com.Proyecto.Repository.LibrosRepository;

@Service
public class LibrosServiceImp implements LibrosService {
    @Autowired
    private LibrosRepository librosRepository;

    @Override
    public Libro save(Libro libro) {
        return librosRepository.save(libro);
    }

    @Override
    public void update(Libro libro) {
        librosRepository.save(libro);
    }

    @Override
    public void delete(Long id) {
        librosRepository.deleteById(id);
    }

    @Override
    public Optional<Libro> get(Long id) {
        return librosRepository.findById(id);
    }

    @Override
    public List<Libro> getAll() {
        return librosRepository.findAll();
    }

}
