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
  private Long administratorID;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "user_role")
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
