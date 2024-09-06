package com.example.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Introducimos un controlador UserController que utiliza UserService mediante inyección de dependencias con el constructor.
//Esto hace que UserService esté disponible en UserController sin tener que ser creado manualmente (IoC-> Inversión de Control).
@Component
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public User getUser(int id) {
        return userService.getUserById(id);
    }
}
