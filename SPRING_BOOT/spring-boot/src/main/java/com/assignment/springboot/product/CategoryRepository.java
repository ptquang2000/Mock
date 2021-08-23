package com.assignment.springboot.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
  Category findBycategoryType(String categoryType);
}
