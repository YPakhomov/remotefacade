/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands;

import net.griddynamics.api.approach3.Context;

/**
 *
 * @author one
 */
public class Forward<T> implements Command<T>{
    private T param;

    public Forward(T param) {
        this.param = param;
    }
    
    public T exec(Context context) {
        return param;
    }
}
