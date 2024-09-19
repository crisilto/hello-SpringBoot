package com.crisilto.tutorial.services;

import com.crisilto.tutorial.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService{
    public void saveOrder(List<Product> products);
}
