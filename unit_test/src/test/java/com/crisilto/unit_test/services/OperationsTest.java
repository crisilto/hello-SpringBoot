package com.crisilto.unit_test.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OperationsTest {
    private Operations operations;
    @BeforeEach
    public void setUp(){
        operations = new MyOperations();
    }
    @Test
    public void factorialTest(){
        Assertions.assertEquals(operations.factorial(0), 1);
        Assertions.assertEquals(operations.factorial(1), 1);
        Assertions.assertEquals(operations.factorial(4), 24);
        Assertions.assertEquals(operations.factorial(5), 120);
    }

    @Test
    public void factorialFailTest(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            operations.factorial(-1);
        });
        Assertions.assertThrows(ArithmeticException.class, () -> {
            operations.factorial(-10);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            operations.factorial(24);
        });
    }
}
