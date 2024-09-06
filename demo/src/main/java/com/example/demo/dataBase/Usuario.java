package com.example.demo.dataBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    //Constructores, getters y setters
    public Usuario(){}
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    //Getter y setter para el id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    //Getter y setter para el nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
