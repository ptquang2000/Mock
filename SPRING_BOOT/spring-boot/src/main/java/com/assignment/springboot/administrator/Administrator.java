package com.assignment.springboot.administrator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long administratorID;
  private String username;
  private String password;
  private String administratorRole;

  public Long getAdministratorID() {
    return this.administratorID;
  }

  public void setAdministratorID(Long administratorID) {
    this.administratorID = administratorID;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAdministratorRole() {
    return this.administratorRole;
  }

  public void setAdministratorRole(String administratorRole) {
    this.administratorRole = administratorRole;
  }
  
}
