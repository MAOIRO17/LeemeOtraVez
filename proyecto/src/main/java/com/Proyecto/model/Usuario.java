package com.Proyecto.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String email;
    private String tlf;
    private String direccion;
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Libro> libros;
}
