package com.luv2code.springboot.demo.exception;


public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
// Kế thừa RunTumeException bởi vì nó thuộc loại unchecked-> không bắt caller phải try-catch hoặc khai
// báo throws -> Spring's ExceptionHandler tự bắt được 

