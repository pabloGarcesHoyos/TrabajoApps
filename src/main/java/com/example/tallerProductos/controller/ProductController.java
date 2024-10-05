package com.example.tallerProductos.controller;

import com.example.tallerProductos.dto.ProductDto;
import com.example.tallerProductos.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.tallerProductos.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired //Singleton backwards for just one productService instance
    private ProductService productService;

    //This method refers to productService.findAll() method. Brings out every product stored in database table product as a List of products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }


    //This method refers to productService.findById() method. Finds a specific product searching by id
    //If the product is found, maps the ResponseEntity and returns a 200 OK Status.
    //If there is not a product identified by that id, returns 404 Not Found Status
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //This method refers to productService.save() method. Saves a new product in database table product
    @PostMapping
    public Product createProducts(@RequestBody ProductDto productDto) {
        return productService.saveProducts(productDto);
    }

    //This method refers to productService.findById() and productService.save() methods. Finds a specific product searching by id and updates it
    //If the product is found, sets the attributes to the product in edition, saves to update and returns a 200 OK Status.
    //If there is not a product identified by that id, returns 404 Not Found Status
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        Optional<Product> findProduct = productService.findById(id);
        if (findProduct.isPresent()) {
            ProductDto productDto = new ProductDto();
            productDto.setSku(product.getSku());
            productDto.setName(product.getName());
            productDto.setPrice(Double.parseDouble(product.getPrice()));
            productDto.setBrand(product.getBrand());
            productDto.setStore(product.getStore());
            return ResponseEntity.ok(productService.updateProducts(productDto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //This method refers to productService.findById() and productService.deleteById() methods. Finds a specific product searching by id and deletes it
    //If the product is found, deletes it.
    //If there is not a product identified by that id, returns 404 Not Found Status
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducts(@PathVariable long id) {
        if (productService.findById(id).isPresent()) {
            productService.deleteProductsById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
