package com.assignment.springboot.product;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer")
public class Manufacturer implements Serializable{
  @Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long manufacturerID;
  private String manufacturerName;

  public Manufacturer(){

  }

  public Manufacturer(String manufacturer) {
    this.manufacturerName = manufacturer;
  }

  public Long getManufacturerID() {
    return this.manufacturerID;
  }

  public void setManufacturerID(Long manufacturerID) {
    this.manufacturerID = manufacturerID;
  }

  public String getManufacturerName() {
    return this.manufacturerName;
  }

  public void setManufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
  }

  @Override
  public String toString() {
    return "{" +
      "\n\t\tmanufacturerID='" + getManufacturerID() + "'" +
      ",\n\t\tmanufacturerName='" + getManufacturerName() + "'" +
      "\n\t}";
  }

}
