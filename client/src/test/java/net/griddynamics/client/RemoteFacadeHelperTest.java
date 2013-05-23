/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.griddynamics.client;

import net.griddynamics.api.approach3.commands.Command;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author one
 */
public class RemoteFacadeHelperTest {
    
    public RemoteFacadeHelperTest() {
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
     * Test of executeRemotely method, of class RemoteFacadeHelper.
     */
    @Ignore
    @Test
    public void testExecuteRemotely() {
        System.out.println("executeRemotely");
        Command<?>[] commands = null;
        RemoteFacadeHelper.executeRemotely(commands);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}