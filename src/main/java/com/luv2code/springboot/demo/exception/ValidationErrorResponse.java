package com.luv2code.springboot.demo.exception;
import java.util.*;

public class ValidationErrorResponse {
    private int status;
    private Map<String,String> errors;
    private long timeStamp;

    public ValidationErrorResponse(int status,Map<String,String> errors,long timeStamp){
        this.status=status;
        this.errors=errors;
        this.timeStamp=timeStamp;
    }
    public ValidationErrorResponse(){};
    //setter:
    public void setStatus(int status){
        this.status=status;
    }
    public void setErrors(Map<String,String> errors){
        this.errors=errors;
    }
    public void setTimeStamp(long timeStamp){
        this.timeStamp=timeStamp;
    }
    //getter:
    public int getStatus(){
        return this.status;
    }
    public Map<String,String> getErrors(){
        return this.errors;
    }
    public long getTimeStamp(){
        return this.timeStamp;
    }
}   
