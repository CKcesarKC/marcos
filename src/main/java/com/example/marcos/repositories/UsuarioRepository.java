package com.example.marcos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marcos.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
