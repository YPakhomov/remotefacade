/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands.utils;

import java.util.List;
import net.griddynamics.api.approach3.Context;
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
    
    public List<T> exec(Context context) {
        return list;
    }
    
}
