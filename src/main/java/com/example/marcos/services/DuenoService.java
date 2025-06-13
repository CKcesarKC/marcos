package com.example.marcos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.marcos.entities.Dueno;
import com.example.marcos.repositories.DuenoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DuenoService {

    private final DuenoRepository repository;

    public List<Dueno> getAll(){
        return repository.findAll();
    }

    public Dueno getById(Integer id){
        return repository.findById(id).orElse(new Dueno());
    }

    public Dueno insertUpdate(Dueno dueno){
        return repository.save(dueno);
    }

    public Dueno delete(Integer id){
        if (id !=null && repository.existsById(id)){
            Dueno dueno = repository.findById(id).orElseThrow();
            repository.deleteById(id);
            return dueno;
        }
        return new Dueno();
    }
}