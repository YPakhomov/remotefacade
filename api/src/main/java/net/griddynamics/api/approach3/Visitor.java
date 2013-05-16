/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3;

import net.griddynamics.api.approach3.commands.CommandList;
import net.griddynamics.api.approach3.commands.GetProductByIDCommand;
import net.griddynamics.api.approach3.commands.Forward;


/**
 *
 * @author one
 */
public interface Visitor {
    public <T> void visit(Forward<T> f);
    public  void visit(GetProductByIDCommand getProd);
    public void visit(CommandList cmdSet);
}
