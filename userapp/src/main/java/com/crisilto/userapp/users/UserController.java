package com.crisilto.userapp.users;

import com.crisilto.userapp.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Cambiamos de anotación @Component a @RestController.
@RestController //La anotación @RestController es una combinación de @Controller y @ResponseBody, necesaria para crear controladores REST.
//Todos los métodos de esta clase devolverán directamente el cuerpo de la respuesta (JSON o texto).
@RequestMapping("/users")  //Mapeamos todas las rutas de /users a este controlador
//Todas las rutas manejadas por este controlador comenzarán con /users.
public class UserController {
    private final UserService userService; //Inyección del servicio de usuario.
    @Autowired //Inyección de dependencias (inyectar el UserService en el controlador).
    //Esto permite a Spring crear automáticamente una instancia de UserService y asignarla al controlador.
    //Haciendo uso de userService todas las operaciones de usuarios son delegadas a él mismo, lo que hace un código más limpio y fácil de mantener.
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping() //Mapea las solicitudes HTTP GET a getAllUsers(), llamando al servicio para obtener todos los resultados.
    //Con ApiResponse el controlador sigue devolviendo respuestas personalizadas usando esa clase.
    public ApiResponse<List<AppUser>> getAllUsers() {
        return new ApiResponse<>("success", "Usuers list obtained correctly", userService.getAllUsers());
    }

    @GetMapping("/paged")
    //Mapea las solicitudes HTTP GET a getUsersPage(), llamando al servicio para obtener una página de resultados.
    public ApiResponse<Page<AppUser>> getUsersPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ApiResponse<>("success", "Users page obtained correctly", userService.getUsersPage(pageable));
    }

    @PostMapping //Mapea las solicitudes HTTP POST a addUser(), llamando al servicio para agregar un nuevo usuario a la lista.
    public ApiResponse<AppUser> addUser(@RequestParam String name){
        AppUser appUser = userService.addUser(name);
        return new ApiResponse<>("success", "User added successfully", appUser);
    }
    @PutMapping("/{id}") //Mapea las solicitudes HTTP PUT a updateUser(), llamando al servicio para actualizar un usuario existente.
    //@PathVariable: Obtiene variables de la ruta (ej., /users/1).
    //@RequestParam: Obtiene los parámetros de la solicitud de la URL (ej., ?name=Crisilto
    public ApiResponse<AppUser> updateUser(@PathVariable int id, @RequestParam String name){
        AppUser appUser = userService.updateUser(id, name);
        if(appUser != null){
            return new ApiResponse<>("success", "User updated successfully", appUser);
        }else{
            return new ApiResponse<>("success", "User not found", null);
        }
    }
    @DeleteMapping("/{id}") //Mapea las solicitudes HTTP DELETE a deleteUser(), llamando al servicio para eliminar un usuario basado en su ID.
    public ApiResponse<AppUser> deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if(isDeleted){
            return new ApiResponse<>("success", "User deleted successfully", null);
        }else{
            return new ApiResponse<>("success", "User not found", null);
        }
    }
}

//Con esta anotación el controlador funcionará mejor dentro del contexto de una aplicación RESTful.