/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.griddynamics.api.approach3.Context;
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
    
    public List<V> exec(Context context) {
        List<T> sourceList = new ArrayList<T>(source.exec(context));
        List<V> result = new ArrayList<V>(sourceList.size());
        for(T elem : sourceList){
            result.add(mapper.apply(elem, context));
        }                
        return result;
    }
}
