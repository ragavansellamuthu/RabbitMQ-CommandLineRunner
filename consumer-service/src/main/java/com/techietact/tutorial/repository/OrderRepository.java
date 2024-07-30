package com.techietact.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.techietact.tutorial.entity.OrderEntity;

import jakarta.transaction.Transactional;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

	@Modifying
	@Transactional
	@Query("UPDATE OrderEntity o SET o.productName=:productName WHERE o.productId=:productId")
	void updateProductName(int productId , String productName);
	
}
