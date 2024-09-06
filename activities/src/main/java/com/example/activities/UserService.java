package com.example.activities;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//Creamos un bean UserService usando la anotación @Component
//@Component permite a Spring gestionar su ciclo de vida.
@Component
public class UserService {
    //El método getUserById es una simulación simple de la obtención de un usuario por ID.
    public User getUserById(int id){
        return new User(id, "NombreUsuario" + id);
    }
    //Estas dos anotaciones sirven para añadir el ciclo de vida al Bean.
    //Permiten ejecutar lógica específica según el momento de vida del Bean.
    @PostConstruct
    public void init() {
        System.out.println("UserService ha sido inicializado");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserService ha sido destruido");
    }
}

