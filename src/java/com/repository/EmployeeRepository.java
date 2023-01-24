/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.connection.Connexion;
import com.entity.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pelz
 */
public class EmployeeRepository {
    
    public static List<Employee> getAllEmployee(){
        List<Employee> employeeList = new ArrayList<>();
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery("select * from public.employee");
            while(rs.next()){
            Employee employee = new Employee();
            employee.setEmpid(rs.getInt("empid"));
            employee.setFirstname(rs.getString("firstname"));
            employee.setLastname(rs.getString("lastname"));
            employee.setEmail(rs.getString("email"));
            employee.setGender(rs.getString("gender"));
            employee.setUsername(rs.getString("username"));
            employee.setPasswd(rs.getString("passwd"));
            employee.setPhonenumber(rs.getInt("phonenumber"));
            employee.setDob(rs.getString("dob"));
            employeeList.add(employee);
            }
            state.close();
            rs.close();
        }catch(SQLException e){
            System.out.println("Error displaying employees "+ e.getMessage());
        }
        return employeeList;
    }
    
    public static Employee findEmployeeById(int id){
        for(Employee employee: getAllEmployee()){
            if(employee.getEmpid()== id){
                return employee;
            }
        }
        return null;
    }
    
    public static void createEmployee(Employee employee){
        try{
            String sql= "insert into public.employee "
                                + "(firstname, lastname, gender, email, username, passwd, phonenumber, dob) "
                                + "VALUES ('"+employee.getFirstname()+"', '"+employee.getLastname()+"', '"+employee.getGender()+"'"
                    + "             , '"+employee.getEmail()+"', '"+employee.getUsername()+"', '"+employee.getPasswd()+"', '"+employee.getPhonenumber()+"'"
                    + "             , '"+employee.getDob()+"')";
            System.out.println(sql);
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error in creating employee: "+e);
        }
    }
    
    public static void updateEmployee(Employee employee){
        String sql = "UPDATE public.employee " +
                    "SET firstname = '"+employee.getFirstname()+"'," +
                    "    lastname = '"+employee.getLastname()+"'," +
                    "    gender='"+employee.getGender()+"'," +
                    "    email = '"+employee.getLastname()+"'," +
                    "    username='"+employee.getGender()+"'," +
                    "    passwd = '"+employee.getLastname()+"'," +
                    "    phonenumber='"+employee.getPhonenumber()+"'" +
                    "    dob = '"+employee.getDob()+"'," +
                    " WHERE empid="+employee.getEmpid();
        
        System.out.println(sql);
        try{
            Statement state = Connexion.seconnecter().createStatement();
            ResultSet rs = state.executeQuery(sql);
            }
            
        catch(SQLException e){
            System.out.println("Error updating employee: "+e);
        }
        
        
        
    }
    public static void saveCustomer (Employee employee){
        if (employee.getEmpid()!=0){
            updateEmployee(employee);
        }else{
            createEmployee(employee);
        }
    }
    
    
    public static boolean delete(int empid){
        Employee employee = findEmployeeById(empid);
        if(employee==null){
            System.out.println("The employee does not exist");
            return false;
        }
            try{
                String sql= "DELETE FROM public.employee WHERE id = "+employee.getEmpid();
                Statement state = Connexion.seconnecter().createStatement();
                state.executeQuery(sql);
                return true;
            } catch(SQLException e){
                System.out.println("");
                return true;
            }
            catch(Exception e){
                System.out.println("Error Deleting employee: "+e);
            }
        return false;
    }
    
    public static boolean delete(Employee employee){
        return delete(employee.getEmpid());
    }
    
    public static boolean deleteForced(Employee employee){
        if(!delete(employee)){
            return false;
        }else{
            return true;
        }
    }
    
    
}
