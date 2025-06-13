package com.example.marcos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.marcos.entities.Mascota;
import com.example.marcos.repositories.MascotaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MascotaService {

    private final MascotaRepository repository;

    public List<Mascota> getAll(){
        return repository.findAll();
    }

    public Mascota getById(Integer id){
        return repository.findById(id).orElse(new Mascota());
    }

    public Mascota insertUpdate(Mascota mascota){
        return repository.save(mascota);
    }

    public Mascota delete(Integer id){
        if (id !=null && repository.existsById(id)){
            Mascota mascota = repository.findById(id).orElseThrow();
            repository.deleteById(id);
            return mascota;
        }
        return new Mascota();
    }

}
