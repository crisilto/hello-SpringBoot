package com.crisilto.userapp.products;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    private List<String> products = new ArrayList<>();
    @GetMapping()
    public List<String> getAllProducts() {
        return products;
    }
    @PostMapping()
    public String addProduct(@RequestParam String product) {
        products.add(product);
        return "Product added: " + product;
    }
    @PutMapping()
    public String updateProduct(@RequestParam String oldProduct, @RequestParam String newProduct) {
        int index = products.indexOf(oldProduct);
        if (index >= 0) {
            products.set(index, newProduct);
            return "Product updated: " + newProduct;
        }
        return "Product not found: " + oldProduct;
    }
    @DeleteMapping()
    public String deleteProduct(@RequestParam String product) {
        int index = products.indexOf(product);
        if (index >= 0) {
            products.remove(index);
            return "Product deleted: " + product;
        }
        return "Product not found: " + product;
    }
}
