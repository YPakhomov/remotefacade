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
        System.out.println(f.runScript("serv1.getID 'first'"));
        System.out.println(f.runScript("serv2.calculate  serv1.getID('first1')"));
        //System.out.println(f.runScript("serv2.calculate ( serv1.getID('first1')")); // script with error
    }
}
