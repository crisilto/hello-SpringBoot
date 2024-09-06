package com.example.demo.controllers;

import com.example.demo.services.Saludar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que esta clase es un controlador REST, todos los métodos retornan datos directamente (en lugar de visitas-> @Controller)
public class SaludarController {
    private final Saludar saludarService;

    @Autowired //Indica a Spring que inyecte automáticamente el bean Saludar en este controlador.
    public SaludarController(Saludar saludarService) {
        this.saludarService = saludarService;
    }

    @GetMapping("/saludar")
    public String saludar(@RequestParam(name = "nombre", defaultValue = "Mundo") String nombre) {
        //@RequestParam se utiliza para obtener parámetros de la URL de la solicitud, en este caso, el nombre de la persona a saludar.
        return saludarService.saludar(nombre);
    }
}
