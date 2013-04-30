/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.commands.Command;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author one
 */
public class TransformListTest {
    
    public TransformListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execBulk method, of class TransformList.
     */
    @Test
    public void testExec() {
        System.out.println("TransformList.exec(null)");
        Context context = null;
        
        //creating the command to retrieve collection of products (stub)
        Command<List<Product>> prods = new Command<List<Product>>(){
            public List<Product> exec(Context context) {                
                return Arrays.asList(new Product(10, "first"), new Product(20, "second"), new Product(30, "third"));
            }
        };
        
        // mapper function
        Function<Product,String> mapper = new GetPropertyFunc<Product, String>("name");
        
        //creating the command to transform list of products, to list of product's names
        TransformList<Product,String> instance = 
                new TransformList<Product, String>(prods, mapper);
        Collection<String> expResult = Arrays.asList("first","second","third");
        Collection<String> result = instance.exec(context);
        System.out.println(result);
        assertEquals(expResult, result);        
    }
}