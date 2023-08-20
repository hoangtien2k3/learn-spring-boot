package com.hoangtien2k3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // test các method lần lượt theo thứ tự
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepositoty employeeRepositoty;


    // JUnit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false) // rollback là phục hồi (@Rollback(value = false) có nghĩa là dữ liệu sẽ bị thay đổi)
    public void saveEmployeeTest() {

        Employee employee = Employee.builder()
                .firstName("hoangtien")
                .lastName("2k3")
                .email("hoangtien2k3qx1@gmail.com")
                .build();

        employeeRepositoty.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(0);
    }


    @Test
    @Order(2)
    public void getEmployeeTest() {

        Employee employee = employeeRepositoty.findById(1L).get();

        Assertions.assertThat(employee.getId()).isEqualTo(1L);
    }


    @Test
    @Order(3)
    public void getListOfEmployeeTest() {

        List<Employee> employeeList = employeeRepositoty.findAll();

        Assertions.assertThat(employeeList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployeeTest() {

        Employee employee = employeeRepositoty.findById(1L).get();

        employee.setEmail("hoangtien@gmail.com");
        Employee employeeUpdate = employeeRepositoty.save(employee);

        Assertions.assertThat(employeeUpdate.getEmail()).isEqualTo("hoangtien@gmail.com");
    }


    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest() {

        Employee employee = employeeRepositoty.findById(1L).get();

        employeeRepositoty.delete(employee);


        Employee employee1 = null;
        Optional<Employee> optionalEmployee = employeeRepositoty.findByEmail("hoangtien@gmail.com");

        if (optionalEmployee.isPresent()) {
            employee1 = optionalEmployee.get();
        }

        Assertions.assertThat(employee1).isNull();

    }



}
