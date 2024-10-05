package com.example.tallerProductos.repository;

import com.example.tallerProductos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
