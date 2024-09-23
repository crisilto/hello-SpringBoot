package com.crisilto.unit_test.services;

import org.springframework.stereotype.Service;

@Service
public class MyOperations implements Operations{
    @Override
    public int factorial(int num) {
        //n -> n * (n - 1) + (n - 2).... *1
        //n >= 0
        if(num < 0) throw new ArithmeticException("Math error");
        if(num > 23) throw new IllegalArgumentException("Overflow from Integer");
        if(num == 1 || num == 0) return 1;
        return num * factorial(num - 1);
    }
}
