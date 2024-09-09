package com.crisilto.userapp.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Repositorio gestionado por Spring.
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
//Extiende JpaRepository proporcionando métodos CRUD listos para usar.
//El primer parámetro (Product) es la entidad que este repositorio manejará, y el segundo (Integer) es el tipo de dato de la clave primaria de esa identidad.