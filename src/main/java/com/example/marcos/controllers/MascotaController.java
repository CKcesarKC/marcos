package com.example.marcos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.marcos.entities.Mascota;
import com.example.marcos.services.MascotaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mascotas")
@RequiredArgsConstructor
public class MascotaController {
    
    private final MascotaService service;

    @GetMapping
    public String listaMascotas(Model model){
        model.addAttribute("mascotas", service.getAll());
        return "features/mascotas/mascotas-list";
    }
    @GetMapping("nuevo")
    public String nuevoDescubridores(Model model){
        model.addAttribute("mascotas", new Mascota());
        return "features/mascotas/mascotas-form";
    }
    @GetMapping("editar/{id}")
    public String editar(@PathVariable Integer id ,Model model){
        model.addAttribute("mascotas", service.getById(id));
        return "features/mascotas/mascotas-form";
    }
    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/mascotas";
    }
    @PostMapping("procesar")
    public String procesar(@Valid @ModelAttribute("mascotas") Mascota mascota,BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "features/mascotas/mascotas-form";
    }
    service.insertUpdate(mascota);
    return "redirect:/mascotas";
    }
}
