package com.mock.project.form;
import java.nio.charset.Charset;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mock.project.security.MyUserDetails;
import com.mock.project.course.Course;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseFormService {
  private final ObjectMapper objectMapper = new ObjectMapper();

  private final RestTemplate restTemplate = new RestTemplate();

  private final String SUCCESS_MESSAGE = "Success";

  private final String FAIL_MESSAGE = "Fail";

  public String processForm(CourseForm courseForm){
    HttpHeaders httpHeaders = generateHeaders();
    try{
      System.out.println(courseForm);
      if (addCourse(new Course(courseForm.getName()), httpHeaders) != null) return SUCCESS_MESSAGE;
      return FAIL_MESSAGE;
    } catch (Exception e) {
      e.printStackTrace();
      return  e.getMessage();
    }
  }
  public void processForm(Long id){
    HttpHeaders httpHeaders = generateHeaders();
    try{
      deleteCourse(new Course(id), httpHeaders);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void deleteCourse(Course course, HttpHeaders httpHeaders) throws JsonProcessingException {
    HttpEntity<?> httpEntity = new HttpEntity<Object>(objectMapper.writeValueAsString(course), httpHeaders);
    restTemplate.exchange("http://localhost:8080/courses", HttpMethod.DELETE, httpEntity, Course.class).getBody();
  }
  private Course addCourse(Course quiz, HttpHeaders httpHeaders) throws JsonProcessingException {
    HttpEntity<?> httpEntity = new HttpEntity<Object>(objectMapper.writeValueAsString(quiz), httpHeaders);
    return restTemplate.exchange("http://localhost:8080/courses", HttpMethod.POST, httpEntity, Course.class).getBody();
  }

  private HttpHeaders generateHeaders() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    MyUserDetails user = (MyUserDetails) auth.getPrincipal();

    String plainCreds = user.getUsername() + ":" + user.getPlainPassword();
    byte[] plainCredsBytes = plainCreds.getBytes(Charset.forName("US-ASCII"));
    byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("Authorization", "Basic " + base64Creds);
    return headers;
  }
}
