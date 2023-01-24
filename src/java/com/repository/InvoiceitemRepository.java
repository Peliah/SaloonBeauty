/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.connection.Connexion;
import com.entity.Invoiceitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pelz
 */
public class InvoiceitemRepository {
    public static List<Invoiceitem> getAllInvoiceitem(){
        List<Invoiceitem> invoiceitemList = new ArrayList<>();
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.invoiceitem");
            while(rs.next()){
            Invoiceitem invoiceitem = new Invoiceitem();
            invoiceitem.setInId(rs.getInt("inId"));
            invoiceitem.setItem(rs.getString("item"));
            invoiceitem.setQuantity(rs.getInt("quantity"));
            invoiceitem.setCost(rs.getDouble("cost"));
            invoiceitemList.add(invoiceitem);
            }
            state.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error displaying invoiceitems "+ e.getMessage());
        }
        return invoiceitemList;
    }
    
    public static Invoiceitem findInvoiceitemById(int id){
        for(Invoiceitem invoiceitem: getAllInvoiceitem()){
            if(invoiceitem.getInId()== id){
                return invoiceitem;
            }
        }
        return null;
    }
    
    public static void createInvoiceitem(Invoiceitem invoiceitem){
        try{
            String sql= "insert into public.invoiceitem "
                                + "(item, quantity, cost) "
                                + "VALUES ('"+invoiceitem.getItem()+"', '"+invoiceitem.getQuantity()+"', '"+invoiceitem.getCost()+"')";
            System.out.println(sql);
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in creating invoiceitem: "+e);
        }
    }
    
    public static void updateInvoiceitem(Invoiceitem invoiceitem){
        String sql = "UPDATE public.invoiceitem " +
                    "SET item = '"+invoiceitem.getItem()+"'," +
                    "    quantity = '"+invoiceitem.getQuantity()+"'," +
                    "    cost='"+invoiceitem.getCost() +
                    " WHERE inId="+invoiceitem.getInId();
        
        System.out.println(sql);
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
            }
            
        catch(SQLException e){
            System.out.println("Error updating invoiceitem: "+e);
        }
        
        
        
    }
    public static void saveCustomer (Invoiceitem invoiceitem){
        if (invoiceitem.getInId()!=0){
            updateInvoiceitem(invoiceitem);
        }else{
            createInvoiceitem(invoiceitem);
        }
    }
    
    
    public static boolean delete(int invoiceitemid){
        Invoiceitem invoiceitem = findInvoiceitemById(invoiceitemid);
        if(invoiceitem==null){
            System.out.println("The invoiceitem does not exist");
            return false;
        }
            try{
                String sql= "DELETE FROM public.invoiceitem WHERE id = "+invoiceitem.getInId();
                Statement state = Connexion.seconnecter().createStatement();
                state.executeQuery(sql);
                return true;
            } catch(SQLException e){
                System.out.println("");
                return true;
            }
            catch(Exception e){
                System.out.println("Error Deleting invoiceitem: "+e);
            }
        return false;
    }
    
    public static boolean delete(Invoiceitem invoiceitem){
        return delete(invoiceitem.getInId());
    }
    
    public static boolean deleteForced(Invoiceitem invoiceitem){
        if(!delete(invoiceitem)){
            return false;
        }else{
            return true;
        }
    }
    
    
}
