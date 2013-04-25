/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.sql.rowset.serial.SerialException;
import net.griddynamics.api.Facade;
import net.griddynamics.api.ServiceException;
import org.springframework.beans.factory.annotation.Required;



/**
 *
 * @author one
 */
public class SimpleFacade implements Facade{
    private FirstService firstService;
    private SecondService secondService;

    @Override
    public int getAndCalculate(String name) {
        return secondService.calculate(firstService.getID(name));
    }
    
    @Override
    public Object runScript(String script) throws ServiceException{
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        engine.put("serv1", firstService);
        engine.put("serv2", secondService);
        try {
            return engine.eval(script);
        } catch (ScriptException ex){
            throw new ServiceException(ex.getMessage());
        }
    }
    
        
    @Required
    public void setFirstService(FirstService firstService) {
        this.firstService = firstService;
    }
    
    @Required
    public void setSecondService(SecondService secondService) {
        this.secondService = secondService;
    }
}
