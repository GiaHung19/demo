package com.luv2code.springboot.demo.rest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.dto.EmployeeResponseDTO;
import com.luv2code.springboot.demo.entity.*;
import com.luv2code.springboot.demo.service.EmployeeService;
import java.util.*;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/employees")
    List<EmployeeResponseDTO> getEmployees(){
        return employeeService.findAll();
    }
    @PostMapping("/employees")
    Employee creatEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }
    @PutMapping("/employees")
    Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
    }
    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable int id){
        return employeeService.findById(id);
    }
}
