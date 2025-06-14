package com.example.marcos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marcos.entities.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario,Integer> {

}
