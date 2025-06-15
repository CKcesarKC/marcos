package com.example.marcos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.marcos.entities.Trabajador;
import com.example.marcos.services.TrabajadorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/trabajadores")
@RequiredArgsConstructor
public class TrabajadorController {

    private final TrabajadorService service;

    @GetMapping
    public String listaTrabajador(Model model){
        model.addAttribute("trabajador", service.getAll());
        return "features/trabajadores/trabajadores-list";
    }
    @GetMapping("nuevo")
    public String nuevoTrabajador(Model model){
        model.addAttribute("trabajador", new Trabajador());
        return "features/trabajadores/trabajadores-form";
    }
    @GetMapping("editar/{id}")
    public String editar(@PathVariable Integer id ,Model model){
        model.addAttribute("trabajador", service.getById(id));
        return "features/trabajadores/trabajadores-form";
    }
    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        service.delete(id);
        return "redirect:/trabajadores";
    }
    @PostMapping("procesar")
    public String procesar(@Valid @ModelAttribute("trabajador") Trabajador trabajadores,BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "features/trabajadores/trabajadores-form";
    }
    service.insertUpdate(trabajadores);
    return "redirect:/trabajadores";
    }
}
