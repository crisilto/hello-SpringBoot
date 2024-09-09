package com.crisilto.userapp.products;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<Product>();

    //Método para obtener todos los productos.
    public List<Product> getAllProducts() {
        return products;
    }

    //Método para agregar un nuevo producto.
    public Product addProduct(String name, double price) {
        Product product = new Product(products.size(), name, price); //Creamos un nuevo producto con ID único.
        products.add(product); //Añadimos el producto a la lista.
        return product;
    }

    //Método para actualizar un producto existente.
    public Product updateProduct(int id, String name, double price) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(name);
                product.setPrice(price);
                return product;
            }
        }
        return null;
    }

    //Método para eliminar un producto existente.
    public boolean deleteProduct(int id) {
        if (id >= 0 && id < products.size()) {
            products.remove(id);
            return true;
        } else {
            return false;
        }
    }
}

