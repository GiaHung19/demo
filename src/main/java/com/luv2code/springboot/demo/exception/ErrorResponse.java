package com.luv2code.springboot.demo.exception;


public class ErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public ErrorResponse(int status,String message,long timeStamp){
        this.status=status;
        this.message=message;
        this.timeStamp=timeStamp;
    }
    public ErrorResponse(){};
    //setter:
    public void setStatus(int status){
        this.status=status;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public void setTimeStamp(long timeStamp){
        this.timeStamp=timeStamp;
    }
    //getter:
    public int getStatus(){
        return this.status;
    }
    public String getMessage(){
        return this.message;
    }
    public long getTimeStamp(){
        return this.timeStamp;
    }

}
