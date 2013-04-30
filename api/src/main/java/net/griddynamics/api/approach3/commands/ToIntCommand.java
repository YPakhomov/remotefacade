/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands;

import java.util.HashMap;
import net.griddynamics.api.approach3.Context;

/**
 *
 * @author one
 */
public class ToIntCommand implements Command<Integer>{
    int param;

    public ToIntCommand(int param) {
        this.param = param;
    }
        
    public Integer exec(Context context) {
        return param;
    }
}
