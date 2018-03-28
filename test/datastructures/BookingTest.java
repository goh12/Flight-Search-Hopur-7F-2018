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
public class BookingTest {
    
    public BookingTest() {
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
     * Test of getId method, of class Booking.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Booking instance = new Booking(1, "123456-7890", 1, "1A");
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSsn method, of class Booking.
     */
    @Test
    public void testGetSsn() {
        System.out.println("getSsn");
        Booking instance = new Booking(1, "123456-7890", 1, "1A");
        String expResult = "123456-7890";
        String result = instance.getSsn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlightId method, of class Booking.
     */
    @Test
    public void testGetFlightId() {
        System.out.println("getFlightId");
        Booking instance = new Booking(1, "123456-7890", 1, "1A");
        int expResult = 1;
        int result = instance.getFlightId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeatId method, of class Booking.
     */
    @Test
    public void testGetSeatId() {
        System.out.println("getSeatId");
        Booking instance = new Booking(1, "123456-7890", 1, "1A");
        String expResult = "1A";
        String result = instance.getSeatId();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Booking.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Booking instance = new Booking(1, "123456-7890", 1, "1A");
        String expResult = "123456-7890 á sæti 1A í flugi 1";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
