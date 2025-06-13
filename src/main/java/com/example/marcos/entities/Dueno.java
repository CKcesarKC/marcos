package com.example.marcos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dueno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "dueño_id")
    private Integer id;

    @Size(max = 20)
    @NotBlank
    @Column(nullable = false, length = 20)
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @Positive
    @Max(99)
    @Min(18)
    @Column(nullable = false)
    private Integer edad;

    
    @JoinColumn(name = "mascota_id")
    @ManyToOne
    private Mascota mascota;

}

