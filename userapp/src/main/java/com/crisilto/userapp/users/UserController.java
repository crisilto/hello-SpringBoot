package com.crisilto.userapp.users;

import com.crisilto.userapp.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Cambiamos de anotación @Component a @RestController.
@RestController //La anotación @RestController es una combinación de @Controller y @ResponseBody, necesaria para crear controladores REST.
//Todos los métodos de esta clase devolverán directamente el cuerpo de la respuesta (JSON o texto).
@RequestMapping("/users")  //Mapeamos todas las rutas de /users a este controlador
//Todas las rutas manejadas por este controlador comenzarán con /users.
public class UserController {
    private List<User> users = new ArrayList<>(); //Simulación de una lista de usuarios
    @GetMapping() //Mapea las solicitudes HTTP GET a getAllUsers(), que devuelve la lista de usuarios.
    public ApiResponse<List<User>> getAllUsers() {
        return new ApiResponse<>("success", "Usuers list obtained correctly", users);
    }
    @PostMapping //Mapea las solicitudes HTTP POST a addUser(), que añade un nuevo usuario a la lista.
    public ApiResponse<User> addUser(@RequestParam String name){
        User user = new User(users.size(), name);
        users.add(user);
        return new ApiResponse<>("success", "User added successfully", user);
    }
    @PutMapping("/{id}") //Mapea las solicitudes HTTP PUT a updateUser(), que actualiza un usuario existente en función de su ID.
    //@PathVariable: Obtiene variables de la ruta (ej., /users/1).
    //@RequestParam: Obtiene los parámetros de la solicitud de la URL (ej., ?name=Crisilto
    public ApiResponse<User> updateUser(@PathVariable int id, @RequestParam String name){
        if(id >= 0 && id < users.size()){
            User user = users.get(id);
            user.setName(name);
        }
        return new ApiResponse<>("success", "User updated successfully", users.get(id));
    }
    @DeleteMapping("/{id}") //Mapea las solicitudes HTTP DELETE a deleteUser(), que elimina un usuario basado en su ID.
    public ApiResponse<User> deleteUser(@PathVariable int id){
        if(id >= 0 && id < users.size()){
            User user = users.remove(id);
            return new ApiResponse<>("success", "User " + user.getName() + " deleted successfully", user);
        }else{
            return new ApiResponse<>("success", "User not found", null);
        }
    }
}

//Con esta anotación el controlador funcionará mejor dentro del contexto de una aplicación RESTful.