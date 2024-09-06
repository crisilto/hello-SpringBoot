package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service //Indica que esta clase es un componente de servicio gestionado por el contenedor de Spring.
public class Saludar {
    public String saludar(String nombre) {
        return "Hola, " + nombre; //El método saludar() devuelve un saludo personalizado.
    }
}
//Se necesita un controlador que use este servicio-> SaludarController