package com.crisilto.userapp.users;

public class User {
    private int id;
    private String name;
    //Constructores, getters y setters
    public User(){}
    public User(int id, String name){
        this.id = id;
        this.name = name;
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
    //Método para mostrar los datos del usuario
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                '}';
    }
}
