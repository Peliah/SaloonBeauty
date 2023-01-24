/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.connection.Connexion;
import com.entity.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pelz
 */
public class ServiceRepository {
    public static List<Service> getAllService(){
        List<Service> serviceList = new ArrayList<>();
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.service");
            while(rs.next()){
            Service service = new Service();
            service.setServiceid(rs.getInt("serviceid"));
            service.setServicename(rs.getString("servicename"));
            service.setServicedesc(rs.getString("servicedesc"));
            service.setPrice(rs.getDouble("price"));
            serviceList.add(service);
            }
            state.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error displaying services "+ e.getMessage());
        }
        return serviceList;
    }
    
    public static Service findServiceById(int id){
        for(Service service: getAllService()){
            if(service.getServiceid()== id){
                return service;
            }
        }
        return null;
    }
    
    public static void createService(Service service){
        try{
            String sql= "insert into public.service "
                                + "(servicename, servicedesc, price) "
                                + "VALUES ('"+service.getServicename()+"', '"+service.getServicedesc()+"', '"+service.getPrice()+"')";
            System.out.println(sql);
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in creating service: "+e);
        }
    }
    
    public static void updateService(Service service){
        String sql = "UPDATE public.service " +
                    "SET servicename = '"+service.getServicename()+"'," +
                    "    servicedesc = '"+service.getServicedesc()+"'," +
                    "    price='"+service.getPrice() +
                    " WHERE serviceid="+service.getServiceid();
        
        System.out.println(sql);
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
            }
            
        catch(SQLException e){
            System.out.println("Error updating service: "+e);
        }
        
        
        
    }
    public static void saveCustomer (Service service){
        if (service.getServiceid()!=0){
            updateService(service);
        }else{
            createService(service);
        }
    }
    
    
    public static boolean delete(int serviceid){
        Service service = findServiceById(serviceid);
        if(service==null){
            System.out.println("The service does not exist");
            return false;
        }
            try{
                String sql= "DELETE FROM public.service WHERE id = "+service.getServiceid();
                Statement state = Connexion.seconnecter().createStatement();
                state.executeQuery(sql);
                return true;
            } catch(SQLException e){
                System.out.println("");
                return true;
            }
            catch(Exception e){
                System.out.println("Error Deleting service: "+e);
            }
        return false;
    }
    
    public static boolean delete(Service service){
        return delete(service.getServiceid());
    }
    
    public static boolean deleteForced(Service service){
        if(!delete(service)){
            return false;
        }else{
            return true;
        }
    }
    
    
}
