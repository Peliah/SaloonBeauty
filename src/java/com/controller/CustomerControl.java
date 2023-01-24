/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.entity.Customer;
import com.repository.CustomerRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pelz
 */
@Path("/customers")
public class CustomerControl {
    @GET
    @Path("/getall")
    @Produces(("application/json"))
    public List<Customer> listCustomer(){
        return CustomerRepository.getAllCustomer();
    }
    
    @GET
    @Path("/getcustomer/{custid}")    
    @Produces(("application/json"))
    public Customer getCustById(@PathParam("custid") int custid){
        return CustomerRepository.findCustomerById(custid);
    }
    
    @POST
    @Path("/submitcustomer")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer saveCust(Customer customer){
       CustomerRepository.createCustomer(customer);
       return customer;
    }
    
    @POST
    @Path("/updatecustomer")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Customer updateCust(Customer customer){
       CustomerRepository.updateCustomer(customer);
       return customer;
    }
    
    @POST
    @Path("/login")
    public String loginemployee(@FormParam("username") String username, @FormParam("passwd") String passwd){
        String result = "false";
        int x = 0;
        try{
                PreparedStatement ps = com.connection.Connexion.seconnecter().prepareStatement("select * from public.customer where username=? and passwd=?");
                ps.setString(1, username);
                ps.setString(2, passwd);
                ResultSet rs =ps.executeQuery();
                if(rs.next()){
                    result = "true";
                    System.out.println("logged in successfully");
                }else{
                    System.out.println("loginfailed");
                }
            } catch(SQLException e){
                System.err.println("Error while loggin customers: " + e);
       }
        return result;
    }

    
    @POST
    @Path("/delete/{custid}")
    @Produces(("application/json"))
    public boolean save(@PathParam("custid") int custid){
        return CustomerRepository.delete(custid);
    }
    
    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean delete(Customer customer){
        return CustomerRepository.delete(customer);
    }
}
