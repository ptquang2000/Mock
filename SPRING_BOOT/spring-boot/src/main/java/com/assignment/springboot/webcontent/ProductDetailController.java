
package com.assignment.springboot.webcontent;

import com.assignment.springboot.product.Product;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductDetailController {
  
  // private static final Logger log = LoggerFactory.getLogger(IndexController.class);

  @Autowired
  public RestTemplate restTemplate;

  @GetMapping(value = "/{productName:^(?!.*favicon.ico).*}")
  public String getProductDetail(@PathVariable String productName, RestTemplate restTemplate, Model model) {
    Product product = restTemplate.getForObject(
        "http://localhost:8080/products/" + productName, Product.class);
    model.addAttribute("product", product);
    // log.info(product.toString());
    return "product-detail";
  }

}
