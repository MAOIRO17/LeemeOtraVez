package com.Proyecto.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    private Long dni;
    private String Nombre;
    private String email;
    private String tlf;
    private String direccion;
    @OneToMany(mappedBy = "usuario")
    private List<Compra> compras;
    @OneToMany(mappedBy = "usuario")
    private List<Libros> libros;

}
