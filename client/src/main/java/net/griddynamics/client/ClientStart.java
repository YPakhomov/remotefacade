package net.griddynamics.client;

import net.griddynamics.api.Facade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ClientStart{
    public static void main( String[] args ){
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        Facade f = context.getBean("facade", Facade.class);
        System.out.println(f.getAndCalculate("first"));
    }
}
