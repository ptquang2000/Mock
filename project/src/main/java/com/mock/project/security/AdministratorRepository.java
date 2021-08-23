package com.mock.project.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Admin, Long> {
  public Admin findByusername(String username);
}
