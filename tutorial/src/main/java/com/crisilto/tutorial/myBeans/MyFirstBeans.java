package com.crisilto.tutorial.myBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //With this annotation we declare this will be a class that contains beans.
//Spring Boot will say: Okay, I'm going to scan each method of this class, whose are annotated with @Bean annotation means that the person who is developing this class wants me to create a Singleton of that instance.

public class MyFirstBeans {
    @Bean
    public MyBean createMyBean(){
        return new MyBean();
    }
}
