package com.assignment.springboot.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {
  
  @Autowired
  private ManufacturerRepository manufacturerRepository;

  public Manufacturer addManufacturer(Manufacturer manufacturer){
    return manufacturerRepository.save(manufacturer);
  }

  public Manufacturer getManufacturerByName(String name){
    return manufacturerRepository.findManufacturerBymanufacturerName(name);
  }
}
