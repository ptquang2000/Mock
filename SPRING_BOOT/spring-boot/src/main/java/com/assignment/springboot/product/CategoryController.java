package com.assignment.springboot.product;

import java.io.Serializable;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CategoryController implements Serializable{
  
  @Autowired
  private CategoryService categoryService;

  @ExceptionHandler(SQLServerException.class)
  public String sqlExcpetionHandler(SQLServerException e){
    return e.getMessage();
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public String httpMessageNotReadableExcpetionHandler(HttpMessageNotReadableException e){
    return e.getMessage();
  }

  @RequestMapping(value="/category", method=RequestMethod.POST)
  public Category addcategory(@RequestBody Category category){
    Category _category = categoryService.getCategoryByType(category.getCategoryType());
    return  (_category != null) ? _category : categoryService.addCategory(new Category(category.getCategoryType()));
  }

  @RequestMapping(value="/category", method=RequestMethod.GET)
  public void printAllCategory(){
    ArrayList<Category> list = new ArrayList<>(categoryService.getAllCategory());
    list.forEach(System.out::println);
  }
}
