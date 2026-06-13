package com.luv2code.springboot.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    //define field:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Employee(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    public Employee(){};
    //setter:
    public void setId(int id){
        this.id=id;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }   
    public void setEmail(String email){
        this.email=email;
    }
    //getter:
    public int getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public String toString(){
        return this.id+"-"+this.firstName+"-"+this.lastName+"-"+this.email;
    }
}
