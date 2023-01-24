/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.connection.Connexion;
import com.entity.Booking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pelz
 */
public class BookingRepository {
    
    
    public static List<Booking> getAllBooking(){
        List<Booking> bookingList = new ArrayList<>();
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.booking");
            while(rs.next()){
            Booking booking = new Booking();
            booking.setBookid(rs.getInt("bookid"));
            booking.setEndtime(rs.getTimestamp("endtime"));
            booking.setStarttime(rs.getTimestamp("starttime"));
            booking.setBookdate(rs.getDate("date"));
            int custid = rs.getInt("customerid");
            booking.setCustomerid(CustomerRepository.findCustomerById(custid));
            bookingList.add(booking);
            }
            state.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error displaying bookings "+ e.getMessage());
        }
        return bookingList;
    }
    
    public static Booking findBookingById(int id){
        for(Booking booking: getAllBooking()){
            if(booking.getBookid()== id){
                return booking;
            }
        }
        return null;
    }
    
    public static void createBooking(Booking booking){
        try{
            String sql= "insert into public.booking "
                                + "(bookdate, starttime, endtime, customerid) "
                                + "VALUES ('"+booking.getBookdate()+"', '"+booking.getStarttime()+"'"
                    + "             , '"+booking.getEndtime()+"', '"+booking.getCustomerid()+")";
            System.out.println(sql);
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in creating booking: "+e);
        }
    }
    
    public static void updateBooking(Booking booking){
        String sql = "UPDATE public.booking " +
                    "    bookdate = '"+booking.getBookdate()+"'," +
                    "    starttime='"+booking.getStarttime()+"'," +
                    "    endtime = '"+booking.getEndtime()+"'" +
                    " WHERE bookid="+booking.getBookid();
        
        System.out.println(sql);
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
            }
            
        catch(SQLException e){
            System.out.println("Error updating booking: "+e);
        }
        
        
        
    }
    public static void saveCustomer (Booking booking){
        if (booking.getBookid()!=0){
            updateBooking(booking);
        }else{
            createBooking(booking);
        }
    }
    
    
    public static boolean delete(int bookid){
        Booking booking = findBookingById(bookid);
        if(booking==null){
            System.out.println("The booking does not exist");
            return false;
        }
            try{
                String sql= "DELETE FROM public.booking WHERE bookid = "+booking.getBookid();
                Statement state = Connexion.seconnecter().createStatement();
                state.executeQuery(sql);
                return true;
            } catch(SQLException e){
                System.out.println("");
                return true;
            }
            catch(Exception e){
                System.out.println("Error Deleting booking: "+e);
            }
        return false;
    }
    
    public static boolean delete(Booking booking){
        return delete(booking.getBookid());
    }
    
    public static boolean deleteForced(Booking booking){
        if(!delete(booking)){
            return false;
        }else{
            return true;
        }
    }
    
    
    
}
