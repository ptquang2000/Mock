package com.mock.project.validation;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserDetails implements UserDetails{

  private Administrator administrator;

  public MyUserDetails(Administrator administrator){
    this.administrator = administrator;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(administrator.getAdministratorRole());
    return Arrays.asList(authority);
  }

  @Override
  public String getPassword() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode(administrator.getPassword());
    return encodedPassword;
  }

  @Override
  public String getUsername() {
    return administrator.getUsername();
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
    return administrator.getPassword();
  }
  
}
