/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.configsalon;

import jakarta.ws.rs.core.Application;
import java.util.Set;

/**
 *
 * @author SPIRIT
 */
@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        //resources.add(com.configsalon.WebsourceResource.class);
        resources.add(com.controller.CustomerControl.class);
        resources.add(com.controller.BookControl.class);
        resources.add(com.controller.EmployeeControl.class);
        resources.add(com.controller.ServiceControl.class);
//        resources.add(com.controller.BookControl.class);


    }
    
}