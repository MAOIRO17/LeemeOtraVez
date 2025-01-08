package com.Proyecto.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compra {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime fecha;
    private double precioTotal;

    @ManyToOne
    private Usuario usuario;
    @OneToOne(mappedBy = "compra")
    private DetalleCompra detalleCompra;
    @OneToMany(mappedBy = "compra")
    private List<Libros> libros;
}
