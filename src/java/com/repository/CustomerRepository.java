/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.connection.Connexion;
import com.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pelz
 */
public class CustomerRepository {
    public static List<Customer> getAllCustomer(){
        List<Customer> customerList = new ArrayList<>();
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.customer");
            while(rs.next()){
            Customer customer = new Customer();
            customer.setCustid(rs.getInt("custid"));
            customer.setFirstname(rs.getString("firstname"));
            customer.setLastname(rs.getString("lastname"));
            customer.setEmail(rs.getString("email"));
            customer.setUsername(rs.getString("username"));
            customer.setPasswd(rs.getString("passwd"));
            customer.setPhonenumber(rs.getInt("phonenumber"));
            customerList.add(customer);
            }
            state.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error displaying customers "+ e.getMessage());
        }
        return customerList;
    }
    
    public static Customer findCustomerById(int id){
        for(Customer customer: getAllCustomer()){
            if(customer.getCustid() == id){
                return customer;
            }
        }
        return null;
    }
    
    public static void createCustomer(Customer customer){
        try{
            String sql= "insert into public.customer "
                                + "(firstname, lastname, email, username, passwd, phonenumber) "
                                + "VALUES ('"+customer.getFirstname()+"', '"+customer.getLastname()+"'"
                    + "             , '"+customer.getEmail()+"', '"+customer.getUsername()+"', '"+customer.getPasswd()+"', '"+customer.getPhonenumber()+"')";
            System.out.println(sql);
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in creating customer: "+e);
        }
    }
    
    public static void updateCustomer(Customer customer){
        String sql = "UPDATE public.customer " +
                    "SET firstname = '"+customer.getFirstname()+"'," +
                    "    lastname = '"+customer.getLastname()+"'," +
                    "    email = '"+customer.getLastname()+"'," +
                    "    username='"+customer.getUsername()+"'," +
                    "    passwd = '"+customer.getLastname()+"'," +
                    "    phonenumber='"+customer.getPhonenumber()+"'" +
                    " WHERE custid="+customer.getCustid();
        
        System.out.println(sql);
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
            }
            
        catch(SQLException e){
            System.out.println("Error updating customer: "+e);
        }
        
        
        
    }
    public static void saveCustomer (Customer customer){
        if (customer.getCustid()!=0){
            updateCustomer(customer);
        }else{
            createCustomer(customer);
        }
    }
    
    
    public static boolean delete(int custid){
        Customer customer = findCustomerById(custid);
        if(customer==null){
            System.out.println("The Customer does not exist");
            return false;
        }
            try{
                String sql= "DELETE FROM public.customer WHERE id = "+customer.getCustid();
                Statement state = Connexion.seconnecter().createStatement();
                state.executeQuery(sql);
                return true;
            } catch(SQLException e){
                System.out.println("");
                return true;
            }
            catch(Exception e){
                System.out.println("Error Deleting customer: "+e);
            }
        return false;
    }
    
    public static boolean delete(Customer customer){
        return delete(customer.getCustid());
    }
    
    public static boolean deleteForced(Customer customer){
        if(delete(customer)){
            return true;
        }else{
            return false;
        }
    }
    
}
