package com.crisilto.unit_test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controllers {

    @GetMapping("/")
    public Map<String, String> home(){
        return new HashMap<>(){{put("message", "Hello Unit Tests");}};
    }

    @GetMapping("/factorial")
    public Map<String, String> factorial(
            @RequestParam int number
    ){
        return new HashMap<>(){{put("message", "Result");}};
    }
}
