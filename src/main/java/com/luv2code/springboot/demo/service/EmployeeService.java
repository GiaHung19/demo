package com.luv2code.springboot.demo.service;
import java.util.*;

import com.luv2code.springboot.demo.dto.EmployeeResponseDTO;

public interface EmployeeService {
    List<EmployeeResponseDTO> findAll();
    EmployeeResponseDTO findById(int id);
    EmployeeResponseDTO save(EmployeeResponseDTO employeeRequestDTO);
    void deleteById(int id);
}
