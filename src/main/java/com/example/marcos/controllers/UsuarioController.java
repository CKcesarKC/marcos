package com.example.marcos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.marcos.entities.Comentario;
import com.example.marcos.entities.Usuario;
import com.example.marcos.services.ComentarioService;
import com.example.marcos.services.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public String listaUsuarios(Model model) {
        model.addAttribute("usuarios", service.getAll());
        return "features/usuarios/usuarios-list";
    }

    @GetMapping("nuevo")
    public String nuevoUsuarios(Model model) {
        model.addAttribute("usuarios", new Usuario());
        return "pages/registrate";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("usuarios", service.getById(id));
        return "pages/registrate";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/usuarios";
    }

    @PostMapping("procesar")
    public String procesar(@Valid @ModelAttribute("usuarios") Usuario usuario, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "pages/registrate";
        }
        service.insertUpdate(usuario);
        return "redirect:/usuarios";
    }
}