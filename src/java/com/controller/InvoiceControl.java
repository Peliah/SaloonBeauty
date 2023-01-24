/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.entity.Invoice;
import com.repository.InvoiceRepository;
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
@Path("/invoice")
public class InvoiceControl {
   @GET
    @Path("/getall")
    @Produces(("application/json"))
    public List<Invoice> listInvoice(){
        return InvoiceRepository.getAllInvoice();
    }
    
    @GET
    @Path("/getinvoice/{inId}")    
    @Produces(("application/json"))
    public Invoice getBookById(@PathParam("bookid") int inId){
        return InvoiceRepository.findInvoiceById(inId);
    }
    
    @POST
    @Path("/submitinvoice")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Invoice saveBook(Invoice invoice){
       InvoiceRepository.createInvoice(invoice);
       return invoice;
    }
    
    @POST
    @Path("/updateinvoice")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Invoice updateBook(Invoice invoice){
       InvoiceRepository.updateInvoice(invoice);
       return invoice;
    }
    
    @POST
    @Path("/delete/{inId}")
    @Produces(("application/json"))
    public boolean save(@PathParam("bookid") int inId){
        return InvoiceRepository.delete(inId);
    }
    
    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean delete(Invoice invoice){
        return InvoiceRepository.delete(invoice);
    } 
}
