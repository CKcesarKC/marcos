package com.example.marcos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.marcos.entities.Comentario;
import com.example.marcos.services.ComentarioService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioService service;

    @GetMapping
    public String listaComentarios(Model model) {
        model.addAttribute("comentarios", service.getAll());
        return "features/comentarios/comentarios-list";
    }

    @GetMapping("nuevo")
    public String nuevoComentario(Model model) {
        model.addAttribute("comentarios", new Comentario());
        return "pages/contactos";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("comentarios", service.getById(id));
        return "pages/contactos";
    }

    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/comentarios";
    }

    @PostMapping("procesar")
    public String procesar(@RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String comentario) {

        Comentario nuevoComentario = new Comentario();
        nuevoComentario.setNombre(nombre);
        nuevoComentario.setCorreo(correo);
        nuevoComentario.setComentario(comentario);

        service.insertUpdate(nuevoComentario);
        return "redirect:/comentarios";
    }
}
