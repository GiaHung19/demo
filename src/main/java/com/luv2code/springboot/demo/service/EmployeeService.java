package com.luv2code.springboot.demo.service;
import java.util.*;

import com.luv2code.springboot.demo.dto.EmployeeResponseDTO;
import com.luv2code.springboot.demo.entity.Employee;

public interface EmployeeService {
    List<EmployeeResponseDTO> findAll();
    EmployeeResponseDTO findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
