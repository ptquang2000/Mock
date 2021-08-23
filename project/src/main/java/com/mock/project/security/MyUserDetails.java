package com.mock.project.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserDetails implements UserDetails{

  private Admin admin;

  public MyUserDetails(Admin admin){
    this.admin = admin;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(admin.getAdministratorRole());
    return Arrays.asList(authority);
  }

  @Override
  public String getPassword() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode(admin.getPassword());
    return encodedPassword;
  }

  @Override
  public String getUsername() {
    return admin.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getPlainPassword(){
    return admin.getPassword();
  }
  
}
