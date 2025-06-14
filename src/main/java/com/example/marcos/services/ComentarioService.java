package com.example.marcos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.marcos.entities.Comentario;
import com.example.marcos.repositories.ComentariosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComentarioService {

        private final ComentariosRepository repository;

    public List<Comentario> getAll(){
        return repository.findAll();
    }

    public Comentario getById(Integer id){
        return repository.findById(id).orElse(new Comentario());
    }

    public Comentario insertUpdate(Comentario comentario){
        return repository.save(comentario);
    }

    public Comentario delete(Integer id){
        if (id !=null && repository.existsById(id)){
            Comentario comentario = repository.findById(id).orElseThrow();
            repository.deleteById(id);
            return comentario;
        }
        return new Comentario();
    }
}
