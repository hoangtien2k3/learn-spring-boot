package com.hoangtien2k3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoangtien2k3.model.Employee;
import com.hoangtien2k3.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc // giả lập web
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // giải lập http method
public class Employee_Test_Controller {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper; // dùng đê map các đối tượng với nhau

    @BeforeEach
    public void setup() {
        employeeRepository.deleteAll();
    }

    @Test  // test phương POST: Create tạo đối tượng và lưu và mysql
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception {
        Employee employee = Employee.builder()
                .firstName("hoangtien2k3")
                .lastName("qx1")
                .email("hoangtien2k3qx1@gmail.com")
                .build();

        ResultActions response = mockMvc
                .perform(post("/api/employees") // giả lập cấu hình POST
                .contentType(MediaType.APPLICATION_JSON)    // kết quả trả về là JSON
                .content(objectMapper.writeValueAsString(employee)));

        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }


    // TEST GET ALL EMPLOYEES: lấy ra danh sách Employee -> return list Employee
    @Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {
        Employee employee1 = Employee.builder()
                .firstName("hoangtien2k3")
                .lastName("qx1")
                .email("hoangtien2k3qx1@gmail.com")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("tienanh")
                .lastName("hoang")
                .email("tienanhhoang@gmail.com")
                .build();

        List<Employee> list = List.of(employee1, employee2);
        employeeRepository.saveAll(list);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/employees"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(list.size())));
    }


    // Test GET by Id:
    @Test
    public void givenListOfEmployees_whenGetByIdEmployees_thenReturnEmployeesList() throws Exception {

        Employee employee = Employee.builder()
                .firstName("hoangtien2k3")
                .lastName("qx1")
                .email("hoangtien2k3qx1@gmail.com")
                .build();

        employeeRepository.save(employee);

        // truyên vào 2 thông số:
        // Get: /api/employees/{id}
        // id Employees
        ResultActions respon = mockMvc.perform(get("/api/employees/{id}", employee.getId()));

        respon.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }


    // UPDATE Employee By Id
    @Test
    public void giveUpdateEmployees_whenPutByIdEmployee_thenReturn404() throws Exception{

        long employeeId = 1L;

        // using 'assertj-core' create entity faster than
        Employee savedEmployee = Employee.builder()
                .firstName("hoangtien2k3")
                .lastName("qx1")
                .email("hoangtien2k3qx1@gmail.com")
                .build();
        employeeRepository.save(savedEmployee);

        Employee updatedEmployee = Employee.builder()
                .firstName("Ram")
                .lastName("Jadhav")
                .email("ram@gmail.com")
                .build();


        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }







}
