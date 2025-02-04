package com.Proyecto.service;

import java.util.List;
import java.util.Optional;

import com.Proyecto.model.Libro;

public interface LibrosService {
    public Libro save(Libro libro);
    public void update(Libro libro);
    public void delete(Long id);
    public Optional<Libro> get(Long id);
    public List<Libro> getAll();
}
