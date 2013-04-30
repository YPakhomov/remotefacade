/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.client;


import java.util.Arrays;
import java.util.List;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.CommandFacade;
import net.griddynamics.api.approach3.commands.GetProductByIDCommand;
import net.griddynamics.api.approach3.commands.Command;
import net.griddynamics.api.approach3.commands.Forward;
import net.griddynamics.api.approach3.commands.GetProductByIDFunc;
import net.griddynamics.api.approach3.commands.GetProperty;
import net.griddynamics.api.approach3.commands.ToIntCommand;
import net.griddynamics.api.approach3.commands.utils.AsListCommand;
import static net.griddynamics.api.approach3.commands.utils.DSL.*;
import net.griddynamics.api.approach3.commands.utils.TransformList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author one
 */
public class CommandTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        CommandFacade f = context.getBean("commandFacade", CommandFacade.class);
        
        Command<Product> c = new GetProductByIDCommand(new ToIntCommand(2));
        Command<List<Product>> td;
        Product pr = f.executeRemotely(c);
        System.out.println(f.executeRemotely(c));
        System.out.println(f.executeRemotely(c));
        System.out.println(f.executeRemotely(new GetProductByIDCommand(new Forward<Integer>(1))));
        System.out.println(f.executeRemotely(new GetProductByIDCommand(new ToIntCommand(133))));
        System.out.println(f.executeRemotely(new GetProperty<String, Product>("name", c)));
        
        
        //Bulk cases
        System.out.println("\n Bulk cases ! \n");
        List<Float> idf = Arrays.asList(1f,2f,3f,4f,5f);
        
        List<Integer> id = Arrays.asList(1,2,3,4,5);
        
        Command<List<Product>> getProds = 
                new TransformList<Integer, Product>(new AsListCommand<Integer>(id), 
                new GetProductByIDFunc());
        
        // same as getProds
        Command<List<Product>> ds = transformList(asList(id), getProductByIDFunc());
        
        System.out.println(f.executeRemotely(getProds));
        
        System.out.println(f.executeRemotely(ds));
    }
}
