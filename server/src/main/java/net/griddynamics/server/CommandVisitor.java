/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.Store;
import net.griddynamics.api.approach3.Visitor;
import net.griddynamics.api.approach3.commands.Command;
import net.griddynamics.api.approach3.commands.CommandList;
import net.griddynamics.api.approach3.commands.FindAppropriateStores;
import net.griddynamics.api.approach3.commands.GetProductByIDCommand;
import net.griddynamics.api.approach3.commands.GetProducts;
import net.griddynamics.api.approach3.commands.utils.TransformList;

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
    }

    @Override
    public void visit(CommandList cmdList) {
        List<Command<?>> commands = cmdList.getCommandList();

        List<Command<?>> resList = new ArrayList<Command<?>>(commands.size());

        for (Command c : commands) {
            c.accept(this);
            resList.add(c);
        }
        cmdList.setResult(resList);
    }

    @Override
    public void visit(GetProducts getProducts) {
        Command<List<Integer>> idsCommand = getProducts.getIdsCommand();
        idsCommand.accept(this);

        List<Integer> idList = idsCommand.getResult();
        //TODO some check for npe       
        List<Product> resultList = new ArrayList<Product>(idsCommand.getResult().size());
        for (Integer id : idsCommand.getResult()) {
            resultList.add(context.getProductService().getProductByID(id));
        }
        getProducts.setResult(resultList);
    }

    @Override
    public void visit(FindAppropriateStores findCommand) {
        Command<List<Integer>> idCommand = findCommand.getProductsIDList();
        idCommand.accept(this);
        
        
        Set<Integer> ids = new HashSet<Integer>(idCommand.getResult());
        Set<Store> stores = context.getStoreService().getAllStores();
        
        List<Store> resultStores = new ArrayList<Store>();
        
        for (Store s : stores) {
            boolean containsAll = true;
            Set<Integer> products = new HashSet<Integer>(s.getProducts());
            System.err.println(s);
            for (Integer i : ids) {
                System.err.println(i + " " + products.contains(i));
                if (!products.contains(i)) {
                    containsAll = false;
                    //break;
                }
            }
            if(containsAll){
               resultStores.add(s);
            }
        }
        findCommand.setResult(resultStores);
    }

    @Override
    public void visit(TransformList transformList) {
        Command sourceCommand = transformList.getSource();
       // if(sourceCommand.getResult() == null){ // check for npe, causes  npe :)
       //     sourceCommand.accept(this);
       // }
        sourceCommand.accept(this);
        
        List sourseList = (List)sourceCommand.getResult();
        List resultList = new ArrayList(sourseList.size());
        
        for(Object o : sourseList){
            resultList.add(transformList.getMapper().apply(o));
        }
        
        transformList.setResult(resultList);        
    }
}
