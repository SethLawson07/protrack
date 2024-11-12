package com.protrack.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.protrack.api.entity.Category;


public interface ICategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByNameIgnoreCase(String name);
    
}
