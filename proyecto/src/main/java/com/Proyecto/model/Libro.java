package com.Proyecto.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String idioma;
    private float precio;
    private String imagen;

    @ManyToOne
    @ToString.Exclude
    private Usuario usuario;
}
