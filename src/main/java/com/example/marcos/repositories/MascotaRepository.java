package com.example.marcos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marcos.entities.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota,Integer> {

}
