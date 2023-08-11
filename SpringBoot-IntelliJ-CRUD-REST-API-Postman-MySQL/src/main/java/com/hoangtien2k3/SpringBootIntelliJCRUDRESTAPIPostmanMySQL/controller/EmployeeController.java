package com.hoangtien2k3.SpringBootIntelliJCRUDRESTAPIPostmanMySQL.controller;

import com.hoangtien2k3.SpringBootIntelliJCRUDRESTAPIPostmanMySQL.exception.ResourceNotFoundException;
import com.hoangtien2k3.SpringBootIntelliJCRUDRESTAPIPostmanMySQL.model.Employee;
import com.hoangtien2k3.SpringBootIntelliJCRUDRESTAPIPostmanMySQL.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping // lấy ra tất cả thông tin về Employees
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // build get employee by id REST API
    @GetMapping("{id}") // lấy ra thông tin Employee theo Id ( trả về cho chúng ra một ResponseEntity
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));

        // ResponseEntity.ok(employee): có nghĩa là nó chấp thuận HTTP và trả về ResponseEntity đó
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee); // chấp thuận HTTP đó có sự thay đổi body
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        employeeRepository.delete(employee);

        // nghĩa là nó thông báo tới HTTP là status này không còn nội dung gì nữa
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
