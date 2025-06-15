package com.example.marcos.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Producto {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 4,max = 4)
    @Column(nullable = false, unique = true)
    private String codigo;

    @NotBlank
    @Size(max = 25)
    @Column(nullable = false,length = 25)
    private String nombre;

    @NonNull
    @Positive
    @Column(nullable = false)
    private Integer cantidad;

    @NonNull
    @Column(nullable = false, name = "fecha_registro")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaRegistro;

    @Pattern(regexp = "(?i)BUENO|RECHAZADO", message = "El estado debe ser BUENO o RECHAZADO")
    private String estado;

    @JoinColumn(name = "trabajador_id")
    @ManyToOne
    private Trabajador trabajador;
}
