package com.Proyecto.service;

import java.util.List;
import java.util.Optional;

import com.Proyecto.model.Libros;

public interface LibrosService {
    public Libros save(Libros libro);
    public void update(Libros libro);
    public void delete(Integer id);
    public Optional<Libros> get(Integer id);
    public List<Libros> getAll();
}
