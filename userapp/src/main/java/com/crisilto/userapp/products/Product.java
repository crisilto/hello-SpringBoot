package com.crisilto.userapp.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity //Esta clase es una entidad JPA que será mapeada a una tabla en la bdd.
public class Product {

    @Id //Marca este campo como la clave primaria.
    @GeneratedValue(strategy = GenerationType.AUTO) //Genera automáticamente el valor del ID de manera incremental
    private int id;

    @NotBlank(message = "Name is required") //Validación para el nombre del producto.
    private String name;

    @Positive(message = "Price must be positive") //Validación para el precio del producto.
    private  double price;

    //Construtor vacío requerido por JPA.
    public Product(){}
    //Constructor con parámetros.
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return "Product: [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}