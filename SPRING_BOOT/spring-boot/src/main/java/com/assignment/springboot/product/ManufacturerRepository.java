package com.assignment.springboot.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{

  Manufacturer findManufacturerBymanufacturerName(String name);
  
}
