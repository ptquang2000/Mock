package com.mock.project.security;

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
    Admin admin = administratorRepository.findByusername(username);
    if (admin == null) throw new UsernameNotFoundException(username);
    return new MyUserDetails(admin);
  }
  
}
