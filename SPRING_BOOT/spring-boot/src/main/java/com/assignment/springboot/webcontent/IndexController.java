package com.assignment.springboot.webcontent;

import com.assignment.springboot.product.Product;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class IndexController {
  
  // private static final Logger log = LoggerFactory.getLogger(IndexController.class);

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @GetMapping("/")
  public String getIndex(RestTemplate restTemplate, Model model) {
    Product[] products = restTemplate.getForObject(
        "http://localhost:8080/products", Product[].class);
    model.addAttribute("products", products);
    // for (Product product:products){
    //   log.info(product.toString());
    // } 
		return "index";
  }

}
