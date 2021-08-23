package com.mock.project.validation;

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
    .antMatchers(HttpMethod.POST, "/category").hasRole("ADMIN")
    .antMatchers(HttpMethod.POST, "/manufacturer").hasRole("ADMIN")
    .antMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
    .antMatchers("/administrator").authenticated()
    .and()
    .httpBasic()
    .and()
    // .formLogin()
    //   .permitAll()
    //   .loginPage("/administrator/login")
    //   .loginProcessingUrl("/administrator/doLogin")
    //   .defaultSuccessUrl("/administrator")
    // .and()
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
