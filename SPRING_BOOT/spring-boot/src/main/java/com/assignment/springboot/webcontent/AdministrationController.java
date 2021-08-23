package com.assignment.springboot.webcontent;

import com.assignment.springboot.administrator.ProductForm;
import com.assignment.springboot.administrator.ProductFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdministrationController {
  @Autowired
  private ProductFormService productFormService;

  @GetMapping("/401")
  public String get401(){
    return "401";
  }

  @GetMapping("/500")
  public String get500(){
    return "500";
  }

  @GetMapping("/administrator/login")
  public String getLogin(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || auth instanceof AnonymousAuthenticationToken) {
      return "login";
    }
    return "redirect:/administrator";
  }
  
  @GetMapping("/administrator")
  public String getProductAddForm(Model model) {
    model.addAttribute("productForm", new ProductForm());
		return "product-add";
  }

  @PostMapping("/administrator")
  public String postProductAddSubmit(@ModelAttribute ProductForm productForm, 
  RedirectAttributes redirectAttributes){
    String response = productFormService.processForm(productForm);
    redirectAttributes.addFlashAttribute("message", response);
		return "redirect:/administrator";
  }
}
