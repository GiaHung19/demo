package com.luv2code.springboot.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.springboot.demo.dto.*;


public interface EmployeeRepository extends JpaRepository<EmployeeResponseDTO,Integer>{}
