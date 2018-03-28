/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gudmu
 */
public class AirportTest {
    
    public AirportTest() {
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
     * Test of getName method, of class Airport.
     */
    @Test
    public void testGetName1() {
        System.out.println("getName");
        Airport instance = new Airport("Egilsstaðir");
        String expResult = "Egilsstaðir";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getName method, of class Airport.
     */
    @Test
    public void testGetName2() {
        System.out.println("getName");
        Airport instance = new Airport("");
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getName method, of class Airport.
     */
    @Test(expected=NullPointerException.class)
    public void testGetName3() {
        System.out.println("getName");
        Airport instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }    

    /**
     * Test of toString method, of class Airport.
     */
    @Test
    public void testToString1() {
        System.out.println("toString");
        Airport instance = new Airport("Egilsstaðir");
        String expResult = "Egilsstaðir";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    /**
     * Test of toString method, of class Airport.
     */
    @Test
    public void testToString2() {
        System.out.println("toString");
        Airport instance = new Airport("");
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    /**
     * Test of toString method, of class Airport.
     */
    @Test(expected=NullPointerException.class)
    public void testToString3() {
        System.out.println("toString");
        Airport instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
