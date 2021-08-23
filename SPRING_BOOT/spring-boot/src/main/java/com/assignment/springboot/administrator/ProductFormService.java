package com.assignment.springboot.administrator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.assignment.springboot.product.Category;
import com.assignment.springboot.product.Manufacturer;
import com.assignment.springboot.product.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductFormService {

  private final ObjectMapper objectMapper = new ObjectMapper();

  private final RestTemplate restTemplate = new RestTemplate();

  private final String SUCCESS_MESSAGE = "Success";

  private final String FOLDER = "D:\\HCMUT\\HK6\\CO3325\\PhanTriQuang\\SPRING_BOOT\\spring-boot\\src\\main\\resources\\static\\images";

  private void storeImageUploaded(MultipartFile imageFile, String fileName) throws IOException{
    File uploads = new File(FOLDER);
    File file = new File(uploads, fileName);
    InputStream input = imageFile.getInputStream();
    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
  }

  private HttpHeaders generateHeaders(){
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    MyUserDetails user = (MyUserDetails) auth.getPrincipal();

    String plainCreds = user.getUsername() + ":" + user.getPlainPassword();
    byte[] plainCredsBytes = plainCreds.getBytes(Charset.forName("US-ASCII"));
    byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic " + base64Creds);
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }

  private Category addCategory(String type, HttpHeaders httpHeaders) throws Exception{
    HttpEntity<?> httpEntity = new HttpEntity<Object>(objectMapper.writeValueAsString(
      new Category(type)), httpHeaders);
    return restTemplate.exchange(
      "http://localhost:8080/category",
      HttpMethod.POST,
      httpEntity,
      Category.class)
      .getBody();
  }

  private Manufacturer addManufacturer(String name, HttpHeaders httpHeaders) throws Exception{
    HttpEntity<?> httpEntity = new HttpEntity<Object>(
      objectMapper.writeValueAsString(new Manufacturer(name)), httpHeaders);
    return restTemplate.exchange(
      "http://localhost:8080/manufacturer",
      HttpMethod.POST,
      httpEntity,
      Manufacturer.class)
      .getBody();
  }

  private Product addProduct(Product product, HttpHeaders httpHeaders) throws Exception{
    HttpEntity<?> httpEntity = new HttpEntity<Object>(
      objectMapper.writeValueAsString(product), httpHeaders);
    return restTemplate.exchange(
      "http://localhost:8080/products/" + product.getProductName(),
      HttpMethod.POST,
      httpEntity,
      Product.class)
      .getBody();
  }

  public String processForm(ProductForm productForm){
    HttpHeaders httpHeaders = generateHeaders();
    try{
      Category category = addCategory(productForm.getCategory(), httpHeaders);
      Manufacturer manufacturer = addManufacturer(productForm.getManufacturer(), httpHeaders); 
      String newFileName = restTemplate.getForObject("http://localhost:8080/products/availableImageName", String.class)
        + productForm.getImageFile().getOriginalFilename()
          .substring(productForm.getImageFile().getOriginalFilename().indexOf("."));
      Product product = new Product(productForm, category, manufacturer, newFileName);
      addProduct(product, httpHeaders);
      storeImageUploaded(productForm.getImageFile(), newFileName);
      return SUCCESS_MESSAGE;
    } catch (Exception e) {
      e.printStackTrace();
      return  e.getMessage();
    }
  }
}
