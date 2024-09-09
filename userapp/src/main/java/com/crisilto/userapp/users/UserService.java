package com.crisilto.userapp.users;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service //Marca la clase como un servicio gestionado por Spring.
public class UserService {

    private List<User> users = new ArrayList<>(); //Simulación de una base de datos en memoria.

    //Método para obtener todos los usuarios.
    public List<User> getAllUsers() {
        return users;
    }

    //Método para agregar un nuevo usuario.
    public User addUser(String name) {
        User user = new User(users.size(), name); //Creamos un nuevo usuario con ID único.
        users.add(user); //Añadimos el usuario a la lista.
        return user;
    }
    //Método para actualizar un usuario existente.
    public User updateUser(int id, String name){
        if(id >= 0 && id < users.size()) { //Verificamos si el ID es válido.
            User user = users.get(id); //Obtenemos el usuario a actualizar.
            user.setName(name); //Actualizamos el nombre del usuario.
            return user;
        } else {
            return null; //Si el ID no es válido, retornamos null.
        }
    }

    //Método para eliminar un usuario existente.
    public boolean deleteUser(int id){
        if(id >= 0 && id < users.size()){ //Verificamos si el ID es válido.
            users.remove(id); //Eliminamos el usuario de la lista.
            return true;
        } else {
            return false; //Si el ID no es válido, retornamos false.
        }
    }
}
