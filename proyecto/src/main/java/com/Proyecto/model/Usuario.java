package com.Proyecto.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private String username;
    private String email;
    private String tlf;
    private String direccion;
    private String tipo;
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;

    @ToString.Exclude
    @OneToMany(mappedBy = "usuario")
    private List<Libro> libros;
}
