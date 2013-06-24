/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.client;

import java.util.Arrays;
import java.util.List;
import net.griddynamics.api.Facade;
import net.griddynamics.api.ServiceException;
import net.griddynamics.api.approach3.Product;
import net.griddynamics.api.script.ScriptFacade;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
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
public class ScriptFacadeTest {
    
    private static RemoteFacadeHelper remoteFacadeHelper;
    private static Facade simpleFacade;
    private static Server server;
    
    public ScriptFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        remoteFacadeHelper = new RemoteFacadeHelper();
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        simpleFacade = context.getBean("simpleFacade", Facade.class);
        
        //------Jetty start------        
        server = new Server(8080);
        WebAppContext root = new WebAppContext();
        
        root.setWar("./../server/target/server-1.0-SNAPSHOT.war");
        root.setContextPath("/server");
        
        server.setHandler(root);
        server.start();
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        server.stop();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void sriptTest() throws ServiceException{
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5);

        List<Product> expectedProducts = simpleFacade.getProducts(ids);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        ScriptFacade f = context.getBean("scriptFacade", ScriptFacade.class);
        List<Product> scriptResult = (List)f.runScript("//groovy script\n"
                + "def resultList = []\n"
                + "for(id in [1,2,3,4,5]){\n"
                + "   tmpProduct = productService.getProductByID(id) \n"
                + "   if(tmpProduct.id != 0){ \n  "
                + "      resultList.add(tmpProduct)\n"
                + "   }\n"
                + "}\n"
                + "resultList\n");
        
        assertEquals(scriptResult, expectedProducts);
    }
}