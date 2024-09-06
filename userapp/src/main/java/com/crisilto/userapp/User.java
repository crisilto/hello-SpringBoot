package com.crisilto.userapp;

public class User {
    private int id;
    private String nombre;
    //Constructores, getters y setters
    public User(){}
    public User(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
