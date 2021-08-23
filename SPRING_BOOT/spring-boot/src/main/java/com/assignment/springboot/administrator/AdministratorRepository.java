package com.assignment.springboot.administrator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
  public Administrator findByusername(String username);
}
