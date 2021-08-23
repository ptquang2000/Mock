package com.assignment.springboot.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="category")
public class Category {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY) 
  private Long categoryID;
  private String categoryType;

  public Category(){

  }

  public Category(String categoryType) {
    this.categoryType = categoryType;
  }

  public Long getCategoryID() {
    return this.categoryID;
  }

  public void setCategoryID(Long categoryID) {
    this.categoryID = categoryID;
  }

  public String getCategoryType() {
    return this.categoryType;
  }

  public void setCategoryType(String categoryType) {
    this.categoryType = categoryType;
  }

  @Override
  public String toString() {
    return "{" +
      "\n\t\tcategoryID='" + getCategoryID() + "'" +
      ",\n\t\tcategoryType='" + getCategoryType() + "'" +
      "\n\t}";
  }

}
