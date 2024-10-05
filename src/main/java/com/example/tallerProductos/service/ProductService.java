package com.example.tallerProductos.service;

import com.example.tallerProductos.dto.ProductDto;
import com.example.tallerProductos.entity.Product;
import org.springframework.stereotype.Service;
import com.example.tallerProductos.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public Product saveProducts(ProductDto productDto) {
        Product product = new Product();
        product.setSku(product.getSku());
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setBrand(product.getBrand());
        product.setStore(product.getStore());
        return productRepository.save(product);
    }

    public Product updateProducts(ProductDto productDto) {
        Product product = new Product();
        product.setId(product.getId());
        product.setSku(product.getSku());
        product.setName(product.getName());
        product.setPrice(product.getPrice());
        product.setBrand(product.getBrand());
        product.setStore(product.getStore());
        return productRepository.save(product);
    }

    public void deleteProductsById(long id){
        productRepository.deleteById(id);
    }
}
