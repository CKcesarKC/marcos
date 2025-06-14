package com.example.marcos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.marcos.entities.Dueno;
import com.example.marcos.services.DuenoService;
import com.example.marcos.services.MascotaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/duenos")
@RequiredArgsConstructor
public class DuenoController {

    private final DuenoService duenoService;
    private final MascotaService mascotaService;

    @GetMapping
    public String listaDuenos(org.springframework.ui.Model model){
        model.addAttribute("duenos", duenoService.getAll());
        return "features/duenos/duenos-list";
    }
    @GetMapping("nuevo")
    public String nuevoDinosaurios(org.springframework.ui.Model model){
        model.addAttribute("duenos", new Dueno());
        model.addAttribute("mascotas", mascotaService.getAll());
        return "features/dinosaurio/dinosaurio-form";
    }
    @GetMapping("editar/{id}")
    public String editarDueno(@PathVariable Integer id,org.springframework.ui.Model model){
        model.addAttribute("duenos", duenoService.getById(id));
        model.addAttribute("mascotas", mascotaService.getAll());
        return "features/dinosaurio/dinosaurio-form";
    }
    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer idinteger){
        duenoService.delete(idinteger);
        return "redirect:/dinosaurio";
    }
    
    @PostMapping("procesar")
    public String procesar(@Valid @ModelAttribute Dueno dueno,BindingResult result, org.springframework.ui.Model model) {
    if (result.hasErrors()) {
        model.addAttribute("mascotas", mascotaService.getAll());
        return "features/duenos/duenos-form";
    }
    duenoService.insertUpdate(dueno);
    return "redirect:/duenos";
    }
}
