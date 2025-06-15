package com.example.marcos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marcos.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

}
