/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.client;

import java.util.Arrays;
import java.util.List;
import net.griddynamics.api.Facade;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.approach3.Store;
import net.griddynamics.api.approach3.commands.Command;
import net.griddynamics.api.approach3.commands.FindAppropriateStores;
import net.griddynamics.api.approach3.commands.Forward;
import net.griddynamics.api.approach3.commands.GetProducts;
import net.griddynamics.api.approach3.commands.utils.GetPropertyFunc;
import net.griddynamics.api.approach3.commands.utils.TransformList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author one
 */
public class CommandApproachTest {
    
    private static RemoteFacadeHelper remoteFacadeHelper;
    private static Facade simpleFacade;
    
    public CommandApproachTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        remoteFacadeHelper = new RemoteFacadeHelper();
        
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        simpleFacade = context.getBean("simpleFacade", Facade.class);
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
    
    //@Ignore
    @Test
    public void getProductsTest(){
        List<Integer> ids = Arrays.asList(1,2,3,4,5);
        
        List<Product> expectedProducts = simpleFacade.getProducts(ids);
        
        Command<List<Product>> remoteCommand = new GetProducts(new Forward<List<Integer>>(ids));
        
        remoteFacadeHelper.executeRemotely(remoteCommand);
        
        assertEquals(remoteCommand.getResult(), expectedProducts);
    }
    
    //@Ignore
    @Test
    public void FindStoresWithProductsTest(){
        List<Integer> ids = Arrays.asList(1,2,3,4,5);
        
        List<Store> expectedStores = simpleFacade.findStoresWithProducts(ids);
        
        Command<List<Product>> existingProducts = new GetProducts(new Forward<List<Integer>>(ids));
        
        TransformList<Product,Integer> idsOfexistingProducts = 
                new TransformList<Product, Integer>(existingProducts, new GetPropertyFunc<Product, Integer>("id"));
        
        FindAppropriateStores resultStoresCommand = new FindAppropriateStores(idsOfexistingProducts);
        
        remoteFacadeHelper.executeRemotely(resultStoresCommand);
        
        assertEquals(expectedStores, resultStoresCommand.getResult());
    }
}