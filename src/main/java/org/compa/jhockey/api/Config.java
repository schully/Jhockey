/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compa.jhockey.api;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ElKebabHenry
 */
@javax.ws.rs.ApplicationPath("api")
public class Config extends Application{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(org.compa.jhockey.GameService.class);
        return resources; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
