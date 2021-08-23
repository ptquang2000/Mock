package com.assignment.springboot.product;

import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController{

  @Autowired
  private ProductService productService;

  @RequestMapping("/products")
  public ArrayList<Product> getAllProducts(){
    return productService.getAllProducts();
  }
  
  @RequestMapping("/products/{param}")
  public Product getProduct(@PathVariable String param){
    try{
      return productService.getProductByID(Long.parseLong(param));
    }catch (NumberFormatException e){
      return productService.getProductByName(param);
    }
  }

  @RequestMapping("/products/print")
  public void printAllProducts() throws Exception {
    ArrayList<Product> products = new ArrayList<>(productService.getAllProducts());
    products.forEach(System.out::println);
  }

  @ExceptionHandler(SQLServerException.class)
  public String sqlExceptionHandler(SQLServerException e){
    return e.getMessage();
  }

  @RequestMapping(value = "/products/{productName}", method = RequestMethod.POST)
  public Product addProduct(@RequestBody Product product){
    return productService.addProduct(product);
  }

  @RequestMapping("/products/availableImageName")
  public String countProducts(){
    return "img-" + (productService.countProducts() + 1);
  }
}
