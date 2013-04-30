/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands;

import java.io.Serializable;
import net.griddynamics.api.approach3.Context;


/**
 *
 * @author one
 */
public interface Command<T> extends Serializable{
    T exec(Context context);
}
