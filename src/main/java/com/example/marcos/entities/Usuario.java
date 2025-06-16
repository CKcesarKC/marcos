package com.example.marcos.entities;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 25)
    @Column(nullable = false, length = 25)
    @NotBlank
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String correo;

    @NotBlank
    @Column(nullable = false)
    private String contrasena;

    @NonNull
    @Min(value = 100000000, message = "El teléfono debe tener 9 dígitos")
    @Max(value = 999999999, message = "El teléfono debe tener 9 dígitos")
    @Column(nullable = false, length = 9)
    private Integer telefono;

    @Enumerated(EnumType.STRING)
    @NotNull()
    private Genero genero;

    @NotBlank
    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 50)
    private String direccion;

    @AssertTrue(message = "Debe aceptar los términos y condiciones")
    private boolean terminos;
}