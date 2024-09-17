package com.crisilto.tutorial.services;

import com.crisilto.tutorial.Routes;
import com.crisilto.tutorial.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //This annotation turns our class into a service.
public class OrderService {
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void saveOrder(List<Product> products) {
        System.out.println("Saving order...");
        products.forEach(product -> logger.debug("Product name: {}", product.name));
    }
}
