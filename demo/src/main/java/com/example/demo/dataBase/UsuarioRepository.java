package com.example.demo.dataBase;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository proporciona métodos CRUD básicos (Create, Read, Update, Delete) para manejar la entidad Usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //Spring Data JPA proporcionará las implementaciones básicas de CRUD (Crear, Leer, Actualizar, Borrar)
}
