package com.crisilto.userapp;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Cambiamos de anotación @Component a @RestController.
@RestController //La anotación @RestController es una combinación de @Controller y @ResponseBody, necesaria para crear controladores REST.
//Todos los métodos de esta clase devolverán directamente el cuerpo de la respuesta (JSON o texto).
@RequestMapping("/users")  //Mapeamos todas las rutas de /users a este controlador
//Todas las rutas manejadas por este controlador comenzarán con /users.
public class UserController {
    private List<String> users = new ArrayList<>(); //Simulación de una lista de usuarios
    @GetMapping() //Mapea las solicitudes HTTP GET a getAllUsers(), que devuelve la lista de usuarios.
    public List<String> getAllUsers() {
        return users;
    }
    @PostMapping //Mapea las solicitudes HTTP POST a addUser(), que añade un nuevo usuario a la lista.
    public String addUser(@RequestParam String name){
        users.add(name);
        return "Usuario: " + name + " añadido.";
    }
    @PutMapping("/{id}") //Mapea las solicitudes HTTP PUT a updateUser(), que actualiza un usuario existente en función de su ID.
    //@PathVariable: Obtiene variables de la ruta (ej., /users/1).
    //@RequestParam: Obtiene los parámetros de la solicitud de la URL (ej., ?name=Crisilto
    public String updateUser(@PathVariable int id, @RequestParam String name){
        if(id >= 0 && id < users.size()){
            users.set(id, name);
            return "Usuario: " + name + " actualizado.";
        }
        return "No se encontró el usuario con el ID: " + id;
    }
    @DeleteMapping("/{id}") //Mapea las solicitudes HTTP DELETE a deleteUser(), que elimina un usuario basado en su ID.
    public String deleteUser(@PathVariable int id){
        if(id >= 0 && id < users.size()){
            String user = users.remove(id);
            return "Usuario: " + user + " eliminado.";
        }else{
            return "No se encontró el usuario con el ID: " + id;
        }
    }
}

//Con esta anotación el controlador funcionará mejor dentro del contexto de una aplicación RESTful.