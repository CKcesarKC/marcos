package com.example.marcos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.marcos.entities.Producto;
import com.example.marcos.services.ProductoService;
import com.example.marcos.services.TrabajadorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {


    private final ProductoService productoService;
    private final TrabajadorService trabajadorService;

    @GetMapping
    public String listaDuenos(Model model){
        model.addAttribute("productos", productoService.getAll());
        return "features/productos/productos-list";
    }
    @GetMapping("nuevo")
    public String nuevoProducto(Model model){
        model.addAttribute("productos", new Producto());
        model.addAttribute("trabajadores", trabajadorService.getAll());
        return "features/productos/productos-form";
    }
    @GetMapping("editar/{id}")
    public String editarProducto(@PathVariable Integer id,Model model){
        model.addAttribute("productos", productoService.getById(id));
        model.addAttribute("trabajadores", trabajadorService.getAll());
        return "features/productos/productos-form";
    }
    @GetMapping("eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer idinteger){
        productoService.delete(idinteger);
        return "redirect:/productos";
    }
    
    @PostMapping("procesar")
    public String procesar(@Valid @ModelAttribute("productos") Producto producto,BindingResult result,Model model) {
    if (result.hasErrors()) {
        model.addAttribute("trabajadores", trabajadorService.getAll());
        return "features/productos/productos-form";
    }
    productoService.insertUpdate(producto);
    return "redirect:/productos";
    }
}
