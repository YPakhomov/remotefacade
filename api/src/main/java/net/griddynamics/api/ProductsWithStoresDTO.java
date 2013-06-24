/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.Store;

/**
 *
 * @author one
 */
public class ProductsWithStoresDTO implements Serializable{
    
    private List<Product> products;
    private List<Store> stores;

    public ProductsWithStoresDTO(List<Product> products, List<Store> stores) {
        this.products = products;
        this.stores = stores;
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products);
    }

    public List<Store> getStores() {
        return new ArrayList<Store>(stores);
    }
}
