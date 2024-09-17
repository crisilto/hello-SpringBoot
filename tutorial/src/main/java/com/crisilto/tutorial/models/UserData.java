package com.crisilto.tutorial.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserData {

    public String name;

    @JsonIgnore //This annotation will not show the following property.
    public int age;

    @JsonProperty("real_address") //This annotation will change the name of the following property.
    public String address;

    @JsonValue //This annotation will not show a JSON, just the return value itself.
    public String info(){
        return "Name: " + name + ", Age: " + age + ", Address: " + address;
    }

    @JsonGetter("information") //key
    //This annotation, unlike the previous one, will show the JSON plus new property "information" that contains the information of the return.
    public String infoV2(){
        return "Name: " + name + ", Age: " + age + ", Address: " + address; //value
    }

    public UserData(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
