package com.assignment.springboot.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService{
  
  @Autowired 
  private ProductRepository productRepository;

  public ArrayList<Product> getAllProducts(){
    ArrayList<Product> products = new ArrayList<>();
    productRepository.findAll().forEach(products::add);
    return products;
  }

  public Product getProductByName(String name){
    return productRepository.findByproductName(name);
  }

  public Product getProductByID(Long id){
    return productRepository.findById(id).get();
  }

  public Product addProduct(Product product){
    return productRepository.save(product);
  }

  public Long countProducts(){
    return productRepository.count();
  }

}
