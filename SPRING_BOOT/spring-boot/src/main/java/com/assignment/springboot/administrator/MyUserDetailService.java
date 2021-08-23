package com.assignment.springboot.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService{

  @Autowired
  private AdministratorRepository administratorRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Administrator administrator = administratorRepository.findByusername(username);
    if (administrator == null) throw new UsernameNotFoundException(username);
    return new MyUserDetails(administrator);
  }
  
}
