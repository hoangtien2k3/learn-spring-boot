package com.hoangtien2k3.UnitTestingJUnitMockito.repository;

import com.hoangtien2k3.UnitTestingJUnitMockito.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
