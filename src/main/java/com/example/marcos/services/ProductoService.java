package com.example.marcos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.marcos.entities.Producto;
import com.example.marcos.repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repository;

    public List<Producto> getAll() {
        return repository.findAll();
    }

    public Producto getById(Integer id) {
        return repository.findById(id).orElse(new Producto());
    }

    public Producto insertUpdate(Producto producto) {
        return repository.save(producto);
    }

    public Producto delete(Integer id) {
        if (id != null && repository.existsById(id)) {
            Producto producto = repository.findById(id).orElseThrow();
            repository.deleteById(id);
            return producto;
        }
        return new Producto();
    }
}
