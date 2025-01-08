package com.Proyecto.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class DetalleCompra {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime fecha;
    private double cantidad;
    private double precioTotal;

    @OneToOne
    private Compra compra;
    @OneToOne
    private Libros libros;
}
