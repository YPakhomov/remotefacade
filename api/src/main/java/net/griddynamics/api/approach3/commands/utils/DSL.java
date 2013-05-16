/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands.utils;

import java.util.List;
import net.griddynamics.api.approach3.commands.Command;

/**
 *
 * @author one
 */
public class DSL {
    public static <T> Command<List<T>> asList(List<T> list){
        return new AsListCommand<T>(list);
    }
    public static <T,V>  TransformList<T, V> transformList(Command<List<T>> source, Function<T, V> mapFunc){
        return new TransformList<T, V>(source, mapFunc);
    }
    
}
