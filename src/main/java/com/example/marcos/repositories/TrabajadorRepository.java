package com.example.marcos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marcos.entities.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Integer> {

}
