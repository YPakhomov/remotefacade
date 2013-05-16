/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server;

import java.util.ArrayList;
import java.util.List;
import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.Visitor;
import net.griddynamics.api.approach3.commands.Command;
import net.griddynamics.api.approach3.commands.CommandList;
import net.griddynamics.api.approach3.commands.GetProductByIDCommand;

/**
 *
 * @author one
 */
public class CommandVisitor<T> implements Visitor {
    
    Context context;
    
    public CommandVisitor(Context context) {
        this.context = context;
    }    

    @Override
    public <T> void visit(net.griddynamics.api.approach3.commands.Forward<T> f) {
        
    }

    @Override
    public void visit(GetProductByIDCommand getProd) {
        Command<Integer> id = getProd.getProdID();
        id.accept(this);
        int curID = id.getResult();
        Product resultProduct = context.getProductService().getProductByID(curID);
        getProd.setResult(resultProduct);
        System.err.println("Some action " + resultProduct);
    }

    @Override
    public void visit(CommandList cmdList) {
        List<Command<?>> commands = cmdList.getCommandList();
        
        List<Command<?>> resList = new ArrayList<Command<?>>(commands.size());
        
        for(Command c : commands){
            c.accept(this);
            resList.add(c);
        }
        System.err.println("Alarm ! " + resList.size());
        cmdList.setResult(resList);
    }
}
