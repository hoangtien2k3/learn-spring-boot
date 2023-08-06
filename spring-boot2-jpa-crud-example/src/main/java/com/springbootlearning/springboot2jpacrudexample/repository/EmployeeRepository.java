package com.springbootlearning.springboot2jpacrudexample.repository;

import com.springbootlearning.springboot2jpacrudexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
