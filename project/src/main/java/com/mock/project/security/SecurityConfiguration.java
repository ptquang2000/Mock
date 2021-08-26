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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

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

  @Bean
  public AuthenticationSuccessHandler successHandler() {
    SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
    handler.setUseReferer(true);
    return handler;
  }

  @Bean
  public LogoutSuccessHandler logoutSuccessHandler(){
    SimpleUrlLogoutSuccessHandler handler = new SimpleUrlLogoutSuccessHandler();
    handler.setUseReferer(true);
    return handler;
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
      .successHandler(successHandler())
    .and()
    .logout()
      .permitAll()
      .logoutUrl("/logout")
      .logoutSuccessHandler(logoutSuccessHandler())
    .and()
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
