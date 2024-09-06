package com.crisilto.productapp;

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
        return "Product" + product + " added.";
    }
    @PutMapping()
    public String updateProduct(@RequestParam String oldProduct, @RequestParam String newProduct) {
        int index = products.indexOf(oldProduct);
        if (index >= 0) {
            products.set(index, newProduct);
            return "Product" + oldProduct + " updated to " + newProduct + ".";
        }
        return "Product" + oldProduct + " not found.";
    }
    @DeleteMapping()
    public String deleteProduct(@RequestParam String product) {
        int index = products.indexOf(product);
        if (index >= 0) {
            products.remove(index);
            return "Product" + product + " deleted.";
        }
        return "Product" + product + " not found.";
    }
}
