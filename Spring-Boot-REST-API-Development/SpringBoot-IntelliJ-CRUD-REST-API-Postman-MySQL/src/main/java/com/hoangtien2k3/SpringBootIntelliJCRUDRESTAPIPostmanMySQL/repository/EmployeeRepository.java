package com.hoangtien2k3.SpringBootIntelliJCRUDRESTAPIPostmanMySQL.repository;

import com.hoangtien2k3.SpringBootIntelliJCRUDRESTAPIPostmanMySQL.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // all CRUD database methods
}
