package com.luv2code.springboot.demo.service;
import com.luv2code.springboot.demo.dao.EmployeeRepository;
import com.luv2code.springboot.demo.dto.EmployeeResponseDTO;
import com.luv2code.springboot.demo.entity.Employee;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import org.springframework.stereotype.Service;
import com.luv2code.springboot.demo.exception.*;
import com.luv2code.springboot.demo.dto.*;
import com.luv2code.springboot.demo.dao.*;



@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    public List<EmployeeResponseDTO> findAll(){
        return employeeRepository.findAll();
    }
    public EmployeeResponseDTO findById(int id){
        Optional<EmployeeResponseDTO> employee=employeeRepository.findById(id);
        Employee result=employee.orElseThrow(()->new EmployeeNotFoundException("Not found employee with id:"+id));
        return result;
    }
    @Transactional
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    @Transactional
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }

}
