package com.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Proyecto.model.Libro;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Integer> {

}
