/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.Store;

/**
 *
 * @author one
 */
public class SimpleStoreService {
    private static final Set<Store> stores = new HashSet<Store>();
    private static final Store notFound = new Store(0, "Not Found!", "None", Collections.EMPTY_SET);
    static {
        stores.add(new Store(1, "key", "A", new HashSet<Product>()));
        stores.add(new Store(2, "jug", "A", new HashSet<Product>()));
        stores.add(new Store(3, "key", "B", new HashSet<Product>()));
    }
    
    public Store getStoreByID(int id){
        for(Store s : stores){
            if(s.getId() == id){
                return s;
            }
        }
        return notFound;
    }
    
    public Set<Store> getAllStores(){
        return new HashSet<Store>(stores);
    }
    
    public boolean createStore(Store s){
        return stores.add(s);
    }
    
    public boolean deleteStore(Store s){
        return stores.remove(s);
    }
    
    public boolean updateStore(Store newStore){
        if(stores.remove(newStore)){
            return stores.add(newStore);
        }
        return false;
    }
}
