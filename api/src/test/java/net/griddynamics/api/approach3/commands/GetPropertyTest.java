/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.api.approach3.commands;

import net.griddynamics.api.approach3.Context;
import net.griddynamics.api.approach3.Product;
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
public class GetPropertyTest {
    
    Product product;
    
    public GetPropertyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        product = new Product(10,"test10");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of exec method, of class GetProperty.
     */
    @Test
    public void testExec() {
        System.out.println("exec");        
        Command<Product> func = new Forward<Product>(product);
        GetProperty<String,Product> instance = new GetProperty<String,Product>("name", func);       
        String expresult = "test10";
        String result = instance.exec(null);        
        assertEquals(expresult, result);
        System.out.println(result);
    }
}