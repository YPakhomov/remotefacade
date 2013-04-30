/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands;

import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.servicesinterfaces.ProductService;
import net.griddynamics.api.approach3.Product;

/**
 *
 * @author one
 */
public class GetProductByIDCommand implements Command<Product>{
    Command<Integer> param;

    public GetProductByIDCommand(Command<Integer> param) {
        this.param = param;
    }
        
    public Product exec(Context context) {
        ProductService productService;
        productService = context.getProductService();
        int id = param.exec(context);
        return productService.getProductByID(id);
        //return new Product(50, "First product"); // dummy stub
    }
}
