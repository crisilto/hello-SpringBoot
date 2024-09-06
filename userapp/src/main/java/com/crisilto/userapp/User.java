package com.crisilto.userapp;

public class User {
    private Long id;
    private String nombre;
    //Constructor vacío
    public User() {}
    //Constructor
    public User(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    //Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Método para mostrar los datos del usuario
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
