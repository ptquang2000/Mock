package com.assignment.springboot.webcontent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
  
  @GetMapping("/cart")
  public String getCart(Model model, HttpServletRequest request) {
    String path = (request.getHeader("referer").equals("http://localhost:8080/cart")) 
                  ? "/" : request.getHeader("referer");
    model.addAttribute("url", path);
		return "cart";
  }

}
