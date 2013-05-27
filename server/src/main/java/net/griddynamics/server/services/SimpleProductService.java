/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.server.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.servicesinterfaces.ProductService;

/**
 *
 * @author one
 */
public class SimpleProductService implements ProductService {
    private static final Set<Product> products = new HashSet<Product>();
    public static final Product NOT_FOUND = new Product(0, "Not Found !");

    
    public SimpleProductService() {
        init();
    }
    
    private void init(){
        FileReader sourceFileReader;
        try {
            String sourceName = "prods.txt";      
            sourceFileReader = new FileReader(sourceName);
        } catch (FileNotFoundException ex){
            System.err.println(ex);
            ex.printStackTrace(System.err);
            return;
        }
        
        try {            
            BufferedReader br = new BufferedReader(sourceFileReader);
            for (String line = br.readLine();  line != null; line = br.readLine()) {
                String[] res = line.split(":");
                int id = Integer.parseInt(res[0].trim());
                String name = res[1].trim();
                System.err.println("id : "  + id + " name: " + name);
                Product product = new Product(id, name);
                products.add(product);
            }
        } catch (IOException ex) {
            System.err.println(ex);
            ex.printStackTrace(System.err);
        }        
    }
    
    @Override
    public Product getProductByName(String name){
        for(Product p : products){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return NOT_FOUND;
    }
    
    @Override
    public Product getProductByID(int id){
        for(Product p : products){
            if(p.getId() == id){
                return p;
            }
        }
        return NOT_FOUND;
    }
    
   
    @Override
    public Set<Product> getAllProducts(){
        return new HashSet<Product>(products);
    }
        
}