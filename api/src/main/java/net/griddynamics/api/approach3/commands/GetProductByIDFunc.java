/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands;

import javax.swing.text.AbstractDocument;
import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.commands.utils.Function;

/**
 *
 * @author one
 */
public class GetProductByIDFunc implements Function<Integer, Product>{

    public Product apply(Integer param, Context context) {
        Product p = new GetProductByIDCommand(new Forward<Integer>(param)).exec(context);
        return p;
    }    
}
