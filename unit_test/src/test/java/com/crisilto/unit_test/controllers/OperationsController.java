package com.crisilto.unit_test.controllers;

import com.crisilto.unit_test.services.Operations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})

public class OperationsController {

    @MockBean
    //Creates an Operations mock injecting it into the Spring context besides the real implementation.
    //This is useful to realize controlled unit tests, where you define the behavior of the external dependencies.
    private Operations operationsMock;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    public void setUp(){
        Mockito
                .when(
                        operationsMock
                                .factorial(ArgumentMatchers.anyInt()))
                .thenReturn(0);
    }

    @Test
    public void factorialControllerTest(){
        webTestClient.get()
                .uri("/factorial?number=5")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.message")
                .isEqualTo("Result: 0");
    }
}
