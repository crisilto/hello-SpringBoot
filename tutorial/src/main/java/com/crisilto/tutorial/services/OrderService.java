package com.crisilto.tutorial.services;

import com.crisilto.tutorial.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class OrderService implements IOrderService{

    @Value("${myurls.database}")
    private String databaseUrl;

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public void saveOrder(List<Product> products) {
        System.out.println("Saving order in database " + databaseUrl);
        products.forEach(product -> logger.debug("Product name: {}", product.name));
    }
}
