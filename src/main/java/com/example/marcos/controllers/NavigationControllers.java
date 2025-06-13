package com.example.marcos.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class NavigationControllers {

    @GetMapping
    public String index(Model model){
        List<String> data = new ArrayList<>();
        data.add("Rosa: El servicio fue excelente, brindaron atención rápida y eficiente. Superaron mis expectativas y me hicieron sentir muy bienvenida.");
        data.add("María Fernanda: El servicio fue excepcional. Atendieron todas mis dudas con paciencia y me ofrecieron soluciones a medida.");
        data.add("Javier: El servicio fue increíble. El equipo fue muy atento y resolvió todas mis necesidades de manera rápida y eficiente.");
        model.addAttribute("msj", data);
        return "pages/index";
    }

    @GetMapping ("/carrito")
    public String carrito(){
        return "pages/carrito";
    }
    @GetMapping("/contactos")
    public String contactos(){
        return "pages/contactos";
    }
    @GetMapping("/gatos")
    public String gatos(){
        return "pages/gatos";
    }
    @GetMapping("/iniciar-sesion")
    public String iniciarSesion(){
        return "pages/iniciar-sesion";
    }
    @GetMapping("/nosotros")
    public String nosotros(){
        return "pages/nosotros";
    }
    @GetMapping("/otros")
    public String otros(){
        return "pages/otros";
    }
    @GetMapping("/perros")
    public String perros(){
        return "pages/perros";
    }
    @GetMapping("/registrate")
    public String registrate(){
        return "pages/registrate";
    }

}
