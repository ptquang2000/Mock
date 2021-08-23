package com.assignment.springboot.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category addCategory(Category category){
    return categoryRepository.save(category);
  }

  public Category getCategoryByType(String type){
    return categoryRepository.findBycategoryType(type);
  }

  public List<Category> getAllCategory() {
    return categoryRepository.findAll();
  }
}
