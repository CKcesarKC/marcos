package com.example.marcos.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Mascota {

    @Id
    @Column(nullable = false, unique = true,  name = "mascota_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 25)
    @Column(nullable = false, length = 25)
    private String nombre;

    @NonNull
    @Positive
    @Column(nullable = false)
    private Integer edad;

    /*@FutureOrPresent*/
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false, name = "fecha_adopcion")
    private LocalDate fechaAdopcion;

    @NonNull
    @PositiveOrZero
    @Column(nullable = false)
    private Integer vacunas;

    /*
    @JsonIgnore
    @NonNull
    @OneToMany(mappedBy = "mascota")
    private Set<Dueno> duenos;
     */
}
