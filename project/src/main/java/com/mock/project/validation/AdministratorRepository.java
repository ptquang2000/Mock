package com.mock.project.validation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
  public Administrator findByusername(String username);
}
