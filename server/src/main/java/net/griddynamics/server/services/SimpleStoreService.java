/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.Store;
import net.griddynamics.api.approach3.servicesinterfaces.ProductService;

/**
 *
 * @author one
 */
public class SimpleStoreService {

    private static final Set<Store> stores = new HashSet<Store>();
    private static final Store NOT_FOUND = new Store(0, "Not Found!", "None", Collections.EMPTY_SET);
    
    
//    static {
//        stores.add(new Store(1, "key", "A", new HashSet<Product>()));
//        stores.add(new Store(2, "jug", "A", new HashSet<Product>()));
//        stores.add(new Store(3, "key", "B", new HashSet<Product>()));
//    }
    
    public SimpleStoreService(){
        init();
    }

    private void init() {
        FileReader sourceFileReader;
        try {
            String sourceName = "prods.txt";
            sourceFileReader = new FileReader(sourceName);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
            ex.printStackTrace(System.err);
            return;
        }

        try {
            BufferedReader br = new BufferedReader(sourceFileReader);
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                String[] res = line.split(":");
                int id = Integer.parseInt(res[0].trim());
                String name = res[1].trim();
                String location = res[2].trim();
                HashSet<Integer> products = new HashSet(res.length - 3);
                for (int i = 3; i < res.length; i++) {
                    products.add(Integer.valueOf(res[i].trim()));
                }
                Store store = new Store(id, name, location, products);
                stores.add(store);
            }
        } catch (IOException ex) {
            System.err.println(ex);
            ex.printStackTrace(System.err);
        }
    }

    public Store getStoreByID(int id) {
        for (Store s : stores) {
            if (s.getId() == id) {
                return s;
            }
        }
        return NOT_FOUND;
    }

    public Set<Store> getAllStores() {
        return new HashSet<Store>(stores);
    }

}
