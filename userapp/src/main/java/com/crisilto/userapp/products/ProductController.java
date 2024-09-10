package com.crisilto.userapp.products;

import com.crisilto.userapp.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") // Mapea todas las solicitudes que empiezan con /products a este controlador

public class ProductController {
   private final ProductService productService;
   @Autowired //Inyección de dependencias de ProductService
   public ProductController(ProductService productService) {
       this.productService = productService;
   }
    @GetMapping()
    public ApiResponse<List<Product>> getAllProducts() {
        return new ApiResponse<>("success", "Products list obtained correctly", productService.getAllProducts());
    }

    @GetMapping("/paged") //Nuevo endpoint que maneja solicitudes GET para obtener productos paginados.
    public ApiResponse<Page<Product>> getProductsPage(
            //Los @RequestParam son anotaciones que indican que estos parámetros se pueden pasar en la URL.
            //Son los parámetros para:
            @RequestParam(defaultValue = "0") int page, //La página
            @RequestParam(defaultValue = "10") int size, //El tamaño de la página
            @RequestParam(defaultValue = "name") String sortBy, //La propiedad por la que se ordena.
            @RequestParam(defaultValue = "asc") String direction //La dirección en la que se ordena.
            ) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productsPage = productService.getProductsPage(pageable);
        return new ApiResponse<>("success", "Page of products obtained correctly", productsPage);
    }

    @PostMapping
    public ApiResponse<Product> addProduct(@RequestParam String name, @RequestParam double price) {
        Product product = productService.addProduct(name, price);
        return new ApiResponse<>("success", "Products added correctly", product);
    }
    @PutMapping("/{id}") //Nos aseguramos de que se capture el parámetro ID de la ruta.
    public ApiResponse<Product> updateProduct(@PathVariable int id, @RequestParam String name, @RequestParam double price) {
        Product product = productService.updateProduct(id, name, price);
        if(product != null) {
            return new ApiResponse<>("success", "Product updated correctly", product);
        }else{
            return new ApiResponse<>("error", "Product not found", null);
        }
    }
    @DeleteMapping("/{id}") //Nos aseguramos de que se capture el parámetro ID de la ruta.
    public ApiResponse<Product> deleteProduct(@PathVariable int id) {
        boolean isDeleted = productService.deleteProduct(id);
        if(isDeleted) {
            return new ApiResponse<>("success", "Product deleted correctly", null);
        }else{
            return new ApiResponse<>("error", "Product not found", null);
        }
   }
}