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
public class TransformList<T,V> implements Command<List<V>>{
    private Command<List<T>> source;
    private Function<T,V> mapper;

    public TransformList(Command<List<T>> source, Function<T, V> mapFunc) {
        this.source = source;
        this.mapper = mapFunc;
    }

    public void accept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setResult(List<V> result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<V> getResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
