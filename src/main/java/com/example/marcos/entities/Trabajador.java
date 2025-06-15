package com.example.marcos.entities;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Trabajador {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 8, max = 8)
    @Column(nullable = false, length = 8, unique = true)
    private String codigo;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, length = 25)
    private String nombre;

    @NonNull
    @Max(99)
    @Min(18)
    @Column(nullable = false)
    private Integer edad;

    @NonNull
    @FutureOrPresent
    @Column(nullable = false, name = "fecha_ingreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate FechaIngreso;

    @NotBlank
    @Column(nullable = false)
    private String correo;

    @NotBlank
    @Size(min = 5, max = 80)
    private String direccion;
    
    /*@JsonIgnore
    @NonNull
    @OneToMany(mappedBy = "trabajador")

    private Set<Producto> productos;*/
}
