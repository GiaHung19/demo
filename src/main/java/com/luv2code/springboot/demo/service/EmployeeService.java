package com.luv2code.springboot.demo.service;
import java.util.*;

import com.luv2code.springboot.demo.dto.*;

public interface EmployeeService {
    List<EmployeeResponseDTO> findAll();
    EmployeeResponseDTO findById(int id);
    EmployeeResponseDTO save(int id,EmployeeRequestDTO employeeRequestDTO);
    void deleteById(int id);
}
