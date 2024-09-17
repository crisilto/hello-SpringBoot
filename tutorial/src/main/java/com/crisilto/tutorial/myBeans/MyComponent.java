package com.crisilto.tutorial.myBeans;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    public void greetFromComponent(){
        System.out.println("Hello this is my first Component!");
    }
}
