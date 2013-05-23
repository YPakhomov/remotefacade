package net.griddynamics.client;

import javax.script.ScriptException;
import net.griddynamics.api.Facade;
import net.griddynamics.api.ServiceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ClientStart{
    public static void main( String[] args ) throws ScriptException, ServiceException{
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        Facade f = context.getBean("facade", Facade.class);
        
        System.out.println(f.runScript("productService.getAllProducts()"));
        System.out.println(f.runScript("storeService.getAllStores()"));
    }
}
