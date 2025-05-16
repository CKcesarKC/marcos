package com.example.marcos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class NavigationControllers {

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping ("/carrito")
    public String carrito(){
        return "carrito";
    }
    @GetMapping("/contactos")
    public String contactos(){
        return "contactos";
    }
    @GetMapping("/gatos")
    public String gatos(){
        return "gatos";
    }
    @GetMapping("/iniciar-sesion")
    public String iniciarSesion(){
        return "iniciar-sesion";
    }
    @GetMapping("/nosotros")
    public String nosotros(){
        return "nosotros";
    }
    @GetMapping("/otros")
    public String otros(){
        return "otros";
    }
    @GetMapping("/perros")
    public String perros(){
        return "perros";
    }
    @GetMapping("/registrate")
    public String registrate(){
        return "registrate";
    }

}
