/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api;

import java.util.List;
import net.griddynamics.api.approach3.Product;

/**
 *
 * @author one
 */
public interface Facade {
    
    public List<Product> getProducts(List<Integer> ids);
    
    public StoresWithProductsDTO findStoresWithProducts(List<Integer> ids);
    
}
