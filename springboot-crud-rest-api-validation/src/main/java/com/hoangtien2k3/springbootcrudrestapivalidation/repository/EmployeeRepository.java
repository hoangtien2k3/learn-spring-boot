package com.hoangtien2k3.springbootcrudrestapivalidation.repository;

import com.hoangtien2k3.springbootcrudrestapivalidation.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Create Spring JPA Repository - EmployeeRepository.java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
