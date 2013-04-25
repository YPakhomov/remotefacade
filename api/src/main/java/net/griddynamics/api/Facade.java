/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api;

import javax.script.ScriptException;

/**
 *
 * @author one
 */
public interface Facade {
    public int getAndCalculate(String name);
    public Object runScript(String script) throws ServiceException;
}
