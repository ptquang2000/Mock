package com.mock.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Bean 
  @Override
  protected UserDetailsService userDetailsService() {
    return new MyUserDetailService();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers(HttpMethod.POST, "/courses").hasRole("ADMIN")
    .antMatchers(HttpMethod.POST, "/quiz").hasRole("ADMIN")
    .antMatchers(HttpMethod.PUT, "/courses").hasRole("ADMIN")
    .antMatchers(HttpMethod.PUT, "/quiz").hasRole("ADMIN")
    .antMatchers(HttpMethod.DELETE, "/courses").hasRole("ADMIN")
    .antMatchers(HttpMethod.DELETE, "/quiz").hasRole("ADMIN")
    .and()
    .httpBasic()
    .and()
    .formLogin()
      .permitAll()
      .loginProcessingUrl("/login")
    .and()
    // .logout()
    //   .permitAll()
    //   .logoutUrl("/administrator/logout")
    //   .logoutSuccessUrl("/administrator/login?logout")
    // .and()
    .csrf().disable()
    ; 
  }

  @Bean
  public BCryptPasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(getPasswordEncoder());;
    return authenticationProvider;
  }
  
}
