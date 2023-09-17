package com.hoangtien2k3.UnitTestingJUnitMockito.service.impl;

import com.hoangtien2k3.UnitTestingJUnitMockito.entity.Employee;
import com.hoangtien2k3.UnitTestingJUnitMockito.exception.ResourceNotFoundException;
import com.hoangtien2k3.UnitTestingJUnitMockito.repository.EmployeeRepository;
import com.hoangtien2k3.UnitTestingJUnitMockito.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        Optional<Employee> saveEmployee = employeeRepository.findByEmail(employee.getEmail());
        if (saveEmployee.isPresent()) {
            throw new ResourceNotFoundException("Employee already exists with give email: " + employee.getEmail());
        }

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<Employee> allEmployee = employeeRepository.findAll();
        if (allEmployee.isEmpty()) {
            throw new ResourceNotFoundException("List Employee all empty");
        }

        return allEmployee;
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee) {

        Optional<Employee> checkEmployee = employeeRepository.findById(updatedEmployee.getId());
        if (checkEmployee.isPresent()) {
            throw new ResourceNotFoundException("Not Found Employee All List");
        }

        return employeeRepository.save(updatedEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        Optional<Employee> checkEmployee = employeeRepository.findById(id);
        if (checkEmployee.isPresent()) {
            throw new ResourceNotFoundException("Not Found Employee");
        }

        employeeRepository.deleteById(id);
    }
}
