package com.hoangtien2k3.SpringBoot.DataJpaTest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}