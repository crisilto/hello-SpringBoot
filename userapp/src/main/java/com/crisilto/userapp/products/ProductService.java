package com.crisilto.userapp.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired //Inyectamos el repositorio de productos.
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Método para recuperar todos los productos de la base de datos.
    public List<Product> getAllProducts() {
        return productRepository.findAll(); //Recuperamos los productos de la base de datos.
    }

    //Método para agregar un nuevo producto.
    public Product addProduct(String name, double price) {
        Product product = new Product(name, price);
        return productRepository.save(product); //Guardamos el nuevo producto en la base de datos.
    }

    //Método para actualizar un producto existente.
    public Product updateProduct(int id, String name, double price) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(name);
            product.setPrice(price);
            return productRepository.save(product); //Guardamos los cambios en la base de datos.
        } else {
            return null; //Devolvemos null si el producto no existe.
        }
    }

    //Método para eliminar un producto existente.
    public boolean deleteProduct(int id) {
        if(productRepository.existsById(id)){ //Verificamos si el producto existe por su ID.
            productRepository.deleteById(id); //Eliminamos el producto por su ID.
            return true; //Devolvemos true si el producto se ha eliminado correctamente.
        }else{
            return false; //Devolvemos false si el producto no existe.
        }
    }

    //Método para obtener una página de productos.
    public Page<Product> getProductsPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}

