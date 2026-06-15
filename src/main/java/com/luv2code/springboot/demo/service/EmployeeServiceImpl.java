package com.luv2code.springboot.demo.service;
import com.luv2code.springboot.demo.dao.EmployeeRepository;
import com.luv2code.springboot.demo.dto.EmployeeRequestDTO;
import com.luv2code.springboot.demo.dto.EmployeeResponseDTO;
import com.luv2code.springboot.demo.entity.Employee;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.luv2code.springboot.demo.exception.*;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    public List<EmployeeResponseDTO> findAll(){
        List<Employee> employees=employeeRepository.findAll();
        List<EmployeeResponseDTO> result=employees.stream()
        .map(e->new EmployeeResponseDTO(e.getId(),e.getFirstName(),e.getLastName(),e.getEmail()))
        .collect(Collectors.toList());
    
        return result;
    }
    public EmployeeResponseDTO findById(int id){
        Optional<Employee> employee=employeeRepository.findById(id);
        Employee employees=employee.orElseThrow(()->new EmployeeNotFoundException("Not found employee with id:"+id));
        EmployeeResponseDTO result =new EmployeeResponseDTO(employees.getId(),employees.getFirstName(),employees.getLastName(),employees.getEmail());
        return result;
    }
    @Transactional
    public EmployeeResponseDTO save(int id,EmployeeRequestDTO employeeRequestDTO){
        Employee employee=new Employee(employeeRequestDTO.getFirstName(),employeeRequestDTO.getLastName(),employeeRequestDTO.getEmail());
        employee.setId(id);
        Employee result=employeeRepository.save(employee);//return Employee
        return new EmployeeResponseDTO(result.getId(),result.getFirstName(),result.getLastName(),result.getEmail());
    }
    @Transactional
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }

}
