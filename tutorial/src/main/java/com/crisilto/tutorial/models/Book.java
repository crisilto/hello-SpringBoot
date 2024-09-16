package com.crisilto.tutorial.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    public String name;
    public String editorial;

    public Book() {}

    public Book(String name, String editorial) {
        this.name = name;
        this.editorial = editorial;
    }
}
