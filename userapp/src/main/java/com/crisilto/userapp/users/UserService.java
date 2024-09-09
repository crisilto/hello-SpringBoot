package com.crisilto.userapp.users;

import com.crisilto.userapp.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Marca la clase como un servicio gestionado por Spring.
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Método para obtener todos los usuarios.
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    //Método para agregar un nuevo usuario.
    public AppUser addUser(String name) {
        AppUser appUser = new AppUser(name); //Creamos un nuevo usuario con ID único.
        return userRepository.save(appUser);
    }
    //Método para actualizar un usuario existente.
    public AppUser updateUser(int id, String name){
        Optional<AppUser> userOptional = userRepository.findById(id); //Buscamos el usuario por ID.
        if(userOptional.isPresent()){ //Verificamos si el usuario existe.
            AppUser appUser = userOptional.get();
            appUser.setName(name); //Actualizamos el nombre del usuario.
            return userRepository.save(appUser); //Guardamos los cambios en la base de datos.
        } else {
            throw new IdNotFoundException("User with ID " + id + " does not exist.");
        }
    }

    //Método para eliminar un usuario existente.
    public boolean deleteUser(int id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else{
            throw new IdNotFoundException("User with ID " + id + " does not exist.");
        }
    }

    //Método para obtener una página de usuarios.
    public Page<AppUser> getUsersPage(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
