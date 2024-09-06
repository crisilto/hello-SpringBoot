package com.example.demo.controllers;

import com.example.demo.dataBase.Usuario;
import com.example.demo.dataBase.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que esta clase es un controlador que manejará solicitudes HTTP.
@RequestMapping("/usuarios") //Define la ruta base /usuarios para todas las solicitudes manejadas por este controlador.
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired //Inyecta el repositorio UsuarioRepository para que podamos usarlo dentro del controlador.
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping //Maneja solicitudes GET en /usuarios, devolviendo la lista de todos los usuarios.
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping //Maneja solicitudes POST en /usuarios, permitiendo agregar un nuevo usuario.
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
//Este controlador permite listar todos los usuarios y agregar un nuevo usuario a través de solicitudes HTTP.
