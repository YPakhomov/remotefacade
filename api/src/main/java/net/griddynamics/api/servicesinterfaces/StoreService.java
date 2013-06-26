/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.servicesinterfaces;

import java.util.Set;
import net.griddynamics.api.approach3.Store;

/**
 *
 * @author one
 */
public interface StoreService {
    
    public Store getStoreByID(int id);
    public Set<Store> getAllStores();
    
}
