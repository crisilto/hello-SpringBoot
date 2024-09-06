package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que esta clase es un controlador REST, todos los métodos retornan datos directamente (en lugar de visitas-> @Controller)
public class Hola {
    @GetMapping("/hola") //Define un mapeo para solicitudes HTTP GET en la ruta /hola
    public String hola() { //Este método devolverá un string que será la respuesta directa al cliente
        return "Hola Mundo!";
    }
}
