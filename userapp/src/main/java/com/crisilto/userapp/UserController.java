package com.crisilto.userapp;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Component
public class UserController {
    @GetMapping("/user")
    public String getUser() {
        return "User: Crisilto";
    }
}
