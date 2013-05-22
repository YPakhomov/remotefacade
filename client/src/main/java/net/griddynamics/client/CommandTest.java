/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.griddynamics.api.approach3.CommandFacade;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.Store;
import net.griddynamics.api.approach3.commands.Command;
import net.griddynamics.api.approach3.commands.CommandList;
import net.griddynamics.api.approach3.commands.FindAppropriateStores;
import net.griddynamics.api.approach3.commands.Forward;
import net.griddynamics.api.approach3.commands.GetProductByIDCommand;
import net.griddynamics.api.approach3.commands.GetProducts;
import net.griddynamics.api.approach3.commands.utils.AsListCommand;
import net.griddynamics.api.approach3.commands.utils.GetPropertyFunc;
import net.griddynamics.api.approach3.commands.utils.TransformList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author one
 */
public class CommandTest {

    public static void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        CommandFacade f = context.getBean("commandFacade", CommandFacade.class);


        List<Command<?>> cmdList = new ArrayList<Command<?>>();

        Command<Product> cmdA = new GetProductByIDCommand(new Forward<Integer>(1));
        Command<Product> cmdB = new GetProductByIDCommand(new Forward<Integer>(2));
        Command<Product> cmdC = new GetProductByIDCommand(new Forward<Integer>(20));

        cmdList.add(cmdA);
        cmdList.add(cmdB);
        cmdList.add(cmdC);

        CommandList cl = new CommandList(cmdList);

        Command<List<Command<?>>> resCommand = f.executeRemotely(cl);
        List<Command<?>> resList = resCommand.getResult();

        System.out.println("for");
        for (Command c : resList) {
            System.out.println(c.getResult());
        }
    }
    
    public static void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        CommandFacade f = context.getBean("commandFacade", CommandFacade.class);

        List<Integer> ids = Arrays.asList(1,2,3,4,5);
        
            
        GetProducts products = new GetProducts(new AsListCommand<Integer>(ids));
        
        Command<List<Product>> result = f.executeRemotely(products);
        
        for(Product p : result.getResult()){
            System.out.println(p);
        }
    }
    
    public static void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        CommandFacade f = context.getBean("commandFacade", CommandFacade.class);

        List<Integer> ids = Arrays.asList(1,2,3);
        
            
//        GetProducts products = new GetProducts(new AsListCommand<Integer>(ids));
//        
//        Command<Product> cmdA = new GetProductByIDCommand(new Forward<Integer>(1));
//        Command<Product> cmdB = new GetProductByIDCommand(new Forward<Integer>(2));
//        
//        RemoteFacadeHelper.executeRemotely(products,cmdA, cmdB);
//        
//        for(Product p : products.getResult()){
//            System.out.println(p);
//        }
//        
//        System.out.println("A&B");
//        System.out.println(cmdA.getResult());
//        System.out.println(cmdB.getResult());
        
        FindAppropriateStores cmd = new FindAppropriateStores(new AsListCommand<Integer>(ids));
        RemoteFacadeHelper.executeRemotely(cmd);
        for(Store s : cmd.getResult()){
            System.out.println(s);
        }
    }
    
    public static void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        CommandFacade f = context.getBean("commandFacade", CommandFacade.class);

        List<Integer> ids = Arrays.asList(1,2);
        
            
//        GetProducts products = new GetProducts(new AsListCommand<Integer>(ids));
//        
//        Command<Product> cmdA = new GetProductByIDCommand(new Forward<Integer>(1));
//        Command<Product> cmdB = new GetProductByIDCommand(new Forward<Integer>(2));
//        
//        RemoteFacadeHelper.executeRemotely(products,cmdA, cmdB);
//        
//        for(Product p : products.getResult()){
//            System.out.println(p);
//        }
//        
//        System.out.println("A&B");
//        System.out.println(cmdA.getResult());
//        System.out.println(cmdB.getResult());
        
//        FindAppropriateStores cmd = new FindAppropriateStores(new AsListCommand<Integer>(ids));
//        RemoteFacadeHelper.executeRemotely(cmd);
//        for(Store s : cmd.getResult()){
//            System.out.println(s);
//        }
        
        GetProducts products = new GetProducts(new AsListCommand<Integer>(ids));
        
        TransformList tr = new TransformList(products, new GetPropertyFunc<Product, Integer>("id"));
        
        FindAppropriateStores cmd = new FindAppropriateStores(tr);
        
        RemoteFacadeHelper.executeRemotely(tr,cmd);
        
        for(Object o : tr.getResult()){
            System.out.println((Integer)o);
        }
        
        System.out.println("stores");
        for(Store s : cmd.getResult()){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        test5();
    }
}
