/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.servicesinterfaces;

import java.util.Set;
import net.griddynamics.api.approach3.Store;

/**
 *
 * @author one
 */
public interface StoreService {
    Set<Store> findProduct(int id);
    Set<Store> findProduct(int id, String district);
    
}
