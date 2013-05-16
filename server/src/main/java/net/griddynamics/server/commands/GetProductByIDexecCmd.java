/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server.commands;

import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.servicesinterfaces.ProductService;

/**
 *
 * @author one
 */
public class GetProductByIDexecCmd implements ExecutableCommand<Product>{
    
    private ExecutableCommand<Integer> prodIDCommand;

    public GetProductByIDexecCmd(ExecutableCommand<Integer> prodIDCommand) {
        this.prodIDCommand = prodIDCommand;
    }
    
    @Override
    public Product exec(Context context) {
        ProductService productService;
        productService = context.getProductService();
        int id = prodIDCommand.exec(context);
        return productService.getProductByID(id);
    }
    
}
