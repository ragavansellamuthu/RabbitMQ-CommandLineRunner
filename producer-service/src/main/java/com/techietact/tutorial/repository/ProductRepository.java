package com.techietact.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techietact.tutorial.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
