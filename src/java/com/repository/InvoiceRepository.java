/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.connection.Connexion;
import com.entity.Booking;
import com.entity.Invoice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pelz
 */
public class InvoiceRepository {
    public static List<Invoice> getAllInvoice(){
        List<Invoice> invoiceList = new ArrayList<>();
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.invoice");
            while(rs.next()){
            Invoice invoice = new Invoice();
            invoice.setInvoiceid(rs.getInt("invoiceid"));
            invoice.setInDate(rs.getDate("inDate"));
            invoice.setInvoiceno(rs.getString("invoiceno"));
            Booking booking = new Booking();
            booking.setBookid(rs.getInt("bookingid"));
            invoiceList.add(invoice);
            }
            state.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error displaying invoices "+ e.getMessage());
        }
        return invoiceList;
    }
    
    public static Invoice findInvoiceById(int id){
        for(Invoice invoice: getAllInvoice()){
            if(invoice.getInvoiceid()== id){
                return invoice;
            }
        }
        return null;
    }
    
    public static void createInvoice(Invoice invoice){
        try{
            String sql= "insert into public.invoice "
                                + "(inDate, invoiceno, bookingid) "
                                + "VALUES ('"+invoice.getInDate()+"', '"+invoice.getInvoiceno()+"', '"+invoice.getBookingid().getBookid()+"')";
            System.out.println(sql);
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in creating invoice: "+e);
        }
    }
    
    public static void updateInvoice(Invoice invoice){
        String sql = "UPDATE public.invoice " +
                    "SET invoicename = '"+invoice.getInDate()+"'," +
                    "    invoicedesc = '"+invoice.getInvoiceno()+"'," +
                    "    price='"+invoice.getBookingid() +
                    " WHERE invoiceid="+invoice.getInvoiceid();
        
        System.out.println(sql);
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
            }
            
        catch(SQLException e){
            System.out.println("Error updating invoice: "+e);
        }
        
        
        
    }
    public static void saveCustomer (Invoice invoice){
        if (invoice.getInvoiceid()!=0){
            updateInvoice(invoice);
        }else{
            createInvoice(invoice);
        }
    }
    
    
    public static boolean delete(int invoiceid){
        Invoice invoice = findInvoiceById(invoiceid);
        if(invoice==null){
            System.out.println("The invoice does not exist");
            return false;
        }
            try{
                String sql= "DELETE FROM public.invoice WHERE id = "+invoice.getInvoiceid();
                Statement state = Connexion.seconnecter().createStatement();
                state.executeQuery(sql);
                return true;
            } catch(SQLException e){
                System.out.println("");
                return true;
            }
            catch(Exception e){
                System.out.println("Error Deleting invoice: "+e);
            }
        return false;
    }
    
    public static boolean delete(Invoice invoice){
        return delete(invoice.getInvoiceid());
    }
    
    public static boolean deleteForced(Invoice invoice){
        if(!delete(invoice)){
            return false;
        }else{
            return true;
        }
    }
    
    
}
