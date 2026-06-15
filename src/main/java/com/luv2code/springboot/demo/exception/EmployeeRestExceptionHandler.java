package com.luv2code.springboot.demo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.*;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleEmployeeNotFound(EmployeeNotFoundException exc){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllException(Exception exc){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException exc) {
        Map<String,String> errors=new HashMap<>();
        List<FieldError> listErrors=exc.getBindingResult().getFieldErrors();
        for (FieldError fieldError:listErrors){
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ValidationErrorResponse validationErrorResponse =new ValidationErrorResponse();
        validationErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        validationErrorResponse.setErrors(errors);
        validationErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(validationErrorResponse,HttpStatus.BAD_REQUEST);
    
    }
}

//Dùng ControllerAdvice thay vì @ExceptionHandler là vì nó giải quyết được nỗi đau lặp lại code trong khi logic giống nhau(vi phạm nguyên tắc DRY trong OOP)
