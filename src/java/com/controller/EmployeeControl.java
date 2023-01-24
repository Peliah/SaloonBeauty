/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.entity.Employee;
import com.repository.CustomerRepository;
import com.repository.EmployeeRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author pelz
 */
@Path("/employees")
public class EmployeeControl {
    
        @GET
    @Path("/getall")
    @Produces(("application/json"))
    public List<Employee> listEmployee(){
        return EmployeeRepository.getAllEmployee();
    }
    
    @GET
    @Path("/getemployee/{empid}")    
    @Produces(("application/json"))
    public Employee getCustById(@PathParam("empid") int empid){
        return EmployeeRepository.findEmployeeById(empid);
    }
    
    @POST
    @Path("/submitemployee")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee saveEmp(Employee employee){
       EmployeeRepository.createEmployee(employee);
       return employee;
    }
    
    @POST
    @Path("/updateemployee")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee updateEmp(Employee employee){
       EmployeeRepository.updateEmployee(employee);
       return employee;
    }
    
    @POST
    @Path("/delete/{empid}")
    @Produces(("application/json"))
    public boolean save(@PathParam("empid") int empid){
        return EmployeeRepository.delete(empid);
    }
    
    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean delete(Employee employee){
        return EmployeeRepository.delete(employee);
    }
    
}
