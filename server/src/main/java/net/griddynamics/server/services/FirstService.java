/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server.services;

/**
 *
 * @author one
 */
public class FirstService {
       
    public int getID(String name){
        if(name.equals("first")){
            return 123;
        } else {
            return 456;
        }
    }
}
