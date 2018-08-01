package com.demo.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { 
	
	List<Product> findByNameLike(String name);
	List<Product> findByPriceGreaterThan(Double price);

}

