/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controller;

import com.entity.Booking;
import com.repository.BookingRepository;
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
@Path("/booking")
public class BookControl {
   @GET
    @Path("/getall")
    @Produces(("application/json"))
    public List<Booking> listBooking(){
        return BookingRepository.getAllBooking();
    }
    
    @GET
    @Path("/getbooking/{bookid}")    
    @Produces(("application/json"))
    public Booking getBookById(@PathParam("bookid") int bookingid){
        return BookingRepository.findBookingById(bookingid);
    }
    
    @POST
    @Path("/submitbooking")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking saveBook(Booking booking){
       BookingRepository.createBooking(booking);
       return booking;
    }
    
    @POST
    @Path("/updatebooking")
    @Produces(("application/json"))
    @Consumes(MediaType.APPLICATION_JSON)
    public Booking updateBook(Booking booking){
       BookingRepository.updateBooking(booking);
       return booking;
    }
    
    @POST
    @Path("/delete/{bookid}")
    @Produces(("application/json"))
    public boolean save(@PathParam("bookid") int bookingid){
        return BookingRepository.delete(bookingid);
    }
    
    @POST
    @Path("/delete")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean delete(Booking booking){
        return BookingRepository.delete(booking);
    } 
}
