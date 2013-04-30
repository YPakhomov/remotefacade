/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.servicesinterfaces;

import java.util.Set;
import net.griddynamics.api.approach3.Product;

/**
 *
 * @author one
 */
public interface ProductService {

    boolean addProduct(Product product);

    boolean deleteProduct(Product product);

    Set<Product> getAllProducts();

    Product getProductByID(int id);

    Product getProductByName(String name);

    boolean updateProduct(Product product);
    
}
