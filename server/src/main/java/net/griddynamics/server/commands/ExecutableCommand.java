/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server.commands;

import net.griddynamics.api.approach3.Context;

/**
 *
 * @author one
 */
public interface ExecutableCommand<T> {
    
    public T exec(Context context);
}
