package com.assignment.springboot.product;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {
  
  @Autowired
  private ManufacturerService manufacturerService;

  @ExceptionHandler(SQLServerException.class)
  public String sqlExcpetionHandler(SQLServerException e){
    return e.getMessage();
  }

  @RequestMapping(value="/manufacturer", method=RequestMethod.POST)
  public Manufacturer addManufacturer(@RequestBody Manufacturer manufacturer){
    Manufacturer _manufacturer = manufacturerService.getManufacturerByName(manufacturer.getManufacturerName());
    return  (_manufacturer != null) ? _manufacturer : manufacturerService.addManufacturer(new Manufacturer(manufacturer.getManufacturerName()));
  }
}
