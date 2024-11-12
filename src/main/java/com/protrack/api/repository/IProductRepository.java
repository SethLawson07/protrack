package com.protrack.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protrack.api.entity.Product;


public interface IProductRepository extends JpaRepository<Product,Long> {
    
    Optional<Product> findByNameIgnoreCase(String name);
}
