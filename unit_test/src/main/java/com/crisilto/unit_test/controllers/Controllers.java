package com.crisilto.unit_test.controllers;

import com.crisilto.unit_test.services.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controllers {
    private Operations operations;

    @Autowired
    public Controllers(Operations operations) {
        this.operations = operations;
    }

    @GetMapping("/")
    public Map<String, String> home(){
        return new HashMap<>(){{put("message", "Hello Unit Tests");}};
    }

    @GetMapping("/factorial")
    public Map<String, String> factorial(
            @RequestParam int number
    ){
        try{
            return new HashMap<>(){{put("message", "Result: " +
                    operations.factorial(number)
            );}};
        }catch (ArithmeticException e) {
            return new HashMap<>() {{
                put("message", "Error: Invalid input");
            }};
        }
    }
}
