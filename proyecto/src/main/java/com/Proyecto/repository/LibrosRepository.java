package com.Proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.model.Libros;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {

}
