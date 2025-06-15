package com.example.marcos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.marcos.entities.Trabajador;
import com.example.marcos.repositories.TrabajadorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TrabajadorService {

    private final TrabajadorRepository repository;

    public List<Trabajador> getAll() {
        return repository.findAll();
    }

    public Trabajador getById(Integer id) {
        return repository.findById(id).orElse(new Trabajador());
    }

    public Trabajador insertUpdate(Trabajador trabajador) {
        return repository.save(trabajador);
    }

    public Trabajador delete(Integer id) {
        if (id != null && repository.existsById(id)) {
            Trabajador trabajador = repository.findById(id).orElseThrow();
            repository.deleteById(id);
            return trabajador;
        }
        return new Trabajador();
    }
}
