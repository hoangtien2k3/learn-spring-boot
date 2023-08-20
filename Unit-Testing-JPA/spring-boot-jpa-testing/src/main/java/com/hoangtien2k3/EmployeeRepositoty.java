package com.hoangtien2k3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepositoty extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

}
