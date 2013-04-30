/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api;

import javax.script.ScriptException;
import net.griddynamics.api.approach3.commands.Command;

/**
 *
 * @author one
 */
public interface Facade {
    public int getAndCalculate(String name);
    public Object runScript(String script) throws ServiceException;
}
