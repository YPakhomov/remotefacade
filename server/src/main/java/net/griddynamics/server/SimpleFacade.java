/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server;

import net.griddynamics.api.Facade;
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
    
    @Required
    public void setFirstService(FirstService firstService) {
        this.firstService = firstService;
    }
    
    @Required
    public void setSecondService(SecondService secondService) {
        this.secondService = secondService;
    }
}
