package com.assignment.springboot.product;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
  Product findByproductName(String name);
}
