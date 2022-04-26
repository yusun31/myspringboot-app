package com.example.myspringboot.controller;

import com.example.myspringboot.entity.Employee;
import com.example.myspringboot.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

//    //Constructor Injection (생성자 주입 방식)
//    public EmployeeRestController(UserService userService) {
//        this.employeeService = userService;
//    }

    //POST http://localhost:8087/api/users
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.insertEmployee(employee);
    }

    //GET http://localhost:8087/api/users
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.selectAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.selectEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetail) {
        return employeeService.updateEmployee(id, employeeDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}