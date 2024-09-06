package com.example.activities;

//Creamos una clase User con sus atributos, constructor, getters, setters y método para mostrar su información.
public class User {
    private int id;
    private String name;

    //Constructores, getters y setters
    public User(){}
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //Getter y setter para el id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //Getter y setter para el nombre
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Método para mostrar información del usuario
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
