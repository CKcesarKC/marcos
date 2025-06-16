package com.example.marcos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.marcos.entities.Usuario;
import com.example.marcos.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario getById(Integer id) {
        return repository.findById(id).orElse(new Usuario());
    }

    public Usuario insertUpdate(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario delete(Integer id) {
        if (id != null && repository.existsById(id)) {
            Usuario usuario = repository.findById(id).orElseThrow();
            repository.deleteById(id);
            return usuario;
        }
        return new Usuario();
    }
}
