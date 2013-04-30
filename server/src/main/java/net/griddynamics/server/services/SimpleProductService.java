/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server.services;

import net.griddynamics.api.approach3.servicesinterfaces.ProductService;
import java.util.HashSet;
import java.util.Set;
import net.griddynamics.api.approach3.Product;

/**
 *
 * @author one
 */
public class SimpleProductService implements ProductService {
    private static final Set<Product> products = new HashSet<Product>();
    static final Product notFound = new Product(0, "Not Found !");
    static{
        products.add(new Product(1, "cola"));
        products.add(new Product(2, "twix"));
        products.add(new Product(3, "fish"));
    }
    
    @Override
    public Product getProductByName(String name){
        for(Product p : products){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return notFound;
    }
    
    @Override
    public Product getProductByID(int id){
        for(Product p : products){
            if(p.getId() == id){
                return p;
            }
        }
        return notFound;
    }
    
   
    @Override
    public Set<Product> getAllProducts(){
        return new HashSet<Product>(products);
    }
    
    
    @Override
    public boolean addProduct(Product product){
        return products.add(product);
    }
    
    
    @Override
    public boolean deleteProduct(Product product){
        return products.remove(product);
    }
    
    @Override
    public boolean updateProduct(Product product){
        if(products.remove(product)){
            return products.add(product);
        }
        return false;
    }
}
