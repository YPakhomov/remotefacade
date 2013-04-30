/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.servicesinterfaces.ProductService;

/**
 *
 * @author one
 */
public class GetProperty<T,V> implements Command<T>{
    
    private String propertyName;
    private Command<V> propertyHolderFunc;

    public GetProperty(String propertyName, Command<V> propertyHolderFunc) {
        this.propertyName = propertyName;
        this.propertyHolderFunc = propertyHolderFunc;
    }
    
    public T exec(Context context) {
        Method getter = null;
        V propertyHolder = propertyHolderFunc.exec(context);
        try {
            getter = propertyHolder.getClass().getDeclaredMethod("get"
                    + propertyName.substring(0, 1).toUpperCase()
                    + propertyName.substring(1), null);
        } catch (NoSuchMethodException ex) {
            System.err.println(ex);
            return null;
        } catch (SecurityException ex) {
            System.err.println(ex);
            return null;
        }
        if(getter != null){
            try {
                return (T)getter.invoke(propertyHolder, null);
            } catch (IllegalAccessException ex) {
                System.err.println(ex);
            } catch (IllegalArgumentException ex) {
                System.err.println(ex);
            } catch (InvocationTargetException ex) {
                System.err.println(ex);
            }
        }
        return null;
    }    
}
