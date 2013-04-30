/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands.utils;

import java.io.Serializable;
import net.griddynamics.api.approach3.Context;

/**
 *
 * @author one
 */
public interface Function<T,V> extends Serializable {
    public V apply(T param, Context context);
}
