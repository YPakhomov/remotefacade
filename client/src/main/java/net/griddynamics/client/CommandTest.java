/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.client;

import java.util.ArrayList;
import java.util.List;
import net.griddynamics.api.approach3.CommandFacade;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.commands.Command;
import net.griddynamics.api.approach3.commands.CommandList;
import net.griddynamics.api.approach3.commands.Forward;
import net.griddynamics.api.approach3.commands.GetProductByIDCommand;
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

    public static void main(String[] args) {
        test2();
    }
}
