/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.entity.Service;
import com.repository.ServiceRepository;
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
@Path("/services")
public class ServiceControl {
    @GET
    @Path("/getall")
    @Produces(("application/json"))
    public List<Service> listService(){
        return ServiceRepository.getAllService();
    }
    
    @GET
    @Path("/getservice/{serviceid}")    
    @Produces(("application/json"))
    public Service getCustById(@PathParam("serviceid") int serviceid){
        return ServiceRepository.findServiceById(serviceid);
    }
    
    @POST
    @Path("/submitservice")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Service saveEmp(Service service){
       ServiceRepository.createService(service);
       return service;
    }
    
    @POST
    @Path("/updateservice")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Service updateEmp(Service service){
       ServiceRepository.updateService(service);
       return service;
    }
    
    @POST
    @Path("/delete/{serviceid}")
    @Produces(("application/json"))
    public boolean save(@PathParam("serviceid") int serviceid){
        return ServiceRepository.delete(serviceid);
    }
    
    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean delete(Service service){
        return ServiceRepository.delete(service);
    }
}
