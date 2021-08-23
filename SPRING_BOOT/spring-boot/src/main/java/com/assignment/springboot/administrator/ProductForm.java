package com.assignment.springboot.administrator;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
  private String name;
  private int price;
  private int stock;
  private String description;
  private String manufacturer;
  private String category;
  private int condition;
  private MultipartFile imageFile;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStock() {
    return this.stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getManufacturer() {
    return this.manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getCondition() {
    return this.condition;
  }

  public void setCondition(int condition) {
    this.condition = condition;
  }

  public MultipartFile getImageFile() {
    return this.imageFile;
  }

  public void setImageFile(MultipartFile imageFile) {
    this.imageFile = imageFile;
  }

}
