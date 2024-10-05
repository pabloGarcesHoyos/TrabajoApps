package com.example.tallerProductos.repository;

import com.example.tallerProductos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
