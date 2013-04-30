/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server;

import java.util.HashMap;
import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.servicesinterfaces.ProductService;
import org.springframework.beans.factory.annotation.Required;

/**
 *
 * @author one
 */
class ServerContext implements Context{
    private ProductService productService;

       
    @Override
    public ProductService getProductService() {
        return productService;
    }

    @Required
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
