package com.mock.project.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "user_role")
  private String userRole;

  public Long getAdministratorID() {
    return this.id;
  }

  public void setAdministratorID(Long id) {
    this.id = id;
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
    return this.userRole;
  }

  public void setAdministratorRole(String userRole) {
    this.userRole = userRole;
  }
  
}
