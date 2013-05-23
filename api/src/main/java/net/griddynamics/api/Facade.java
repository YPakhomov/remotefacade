/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api;


/**
 *
 * @author one
 */
public interface Facade {
    public Object runScript(String script) throws ServiceException;
}
