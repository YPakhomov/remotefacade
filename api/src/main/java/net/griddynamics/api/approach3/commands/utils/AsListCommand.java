/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands.utils;

import java.util.List;
import net.griddynamics.api.approach3.Visitor;
import net.griddynamics.api.approach3.commands.Command;

/**
 *
 * @author one
 */
public class AsListCommand<T> implements Command<List<T>>{
    
    private List<T> list;

    public AsListCommand(List<T> list) {
        this.list = list;
    }
        
    public void accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setResult(List<T> result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<T> getResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
