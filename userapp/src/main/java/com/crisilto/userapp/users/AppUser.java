package com.crisilto.userapp.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    //Constructores, getters y setters
    public AppUser(){}
    public AppUser(String name){
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
