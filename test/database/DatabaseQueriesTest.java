/*
 * Petur Sigurdsson, pes14.
 */
package database;

import datastructures.Airport;
import datastructures.Booking;
import datastructures.Flight;
import datastructures.Seat;
import datastructures.User;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author polli
 */
public class DatabaseQueriesTest {
    
    public DatabaseQueriesTest() {
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
     * Test of getAirports method, of class DatabaseQueries.
     */
    @Test
    public void testGetAirports() {
        System.out.println("getAirports");
        ArrayList<Airport> expResult = null;
        ArrayList<Airport> result = DatabaseQueries.getAirports();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlightsToFrom method, of class DatabaseQueries.
     */
    @Test
    public void testGetFlightsToFrom() {
        System.out.println("getFlightsToFrom");
        String originName = "";
        String destinationName = "";
        ArrayList<Flight> expResult = null;
        ArrayList<Flight> result = DatabaseQueries.getFlightsToFrom(originName, destinationName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlightsToFromOnDate method, of class DatabaseQueries.
     */
    @Test
    public void testGetFlightsToFromOnDate() {
        System.out.println("getFlightsToFromOnDate");
        String origin = "";
        String destination = "";
        Date date = null;
        ArrayList<Flight> expResult = null;
        ArrayList<Flight> result = DatabaseQueries.getFlightsToFromOnDate(origin, destination, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlightsToFromBetweenDates method, of class DatabaseQueries.
     */
    @Test
    public void testGetFlightsToFromBetweenDates() {
        System.out.println("getFlightsToFromBetweenDates");
        String origin = "";
        String destination = "";
        Date dateFirst = null;
        Date dateLast = null;
        ArrayList<Flight> expResult = null;
        ArrayList<Flight> result = DatabaseQueries.getFlightsToFromBetweenDates(origin, destination, dateFirst, dateLast);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlightsById method, of class DatabaseQueries.
     */
    @Test
    public void testGetFlightsById() {
        System.out.println("getFlightsById");
        int id = 0;
        Flight expResult = null;
        Flight result = DatabaseQueries.getFlightsById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeatsByFlightId method, of class DatabaseQueries.
     */
    @Test
    public void testGetSeatsByFlightId() {
        System.out.println("getSeatsByFlightId");
        int id = 0;
        ArrayList<Seat> expResult = null;
        ArrayList<Seat> result = DatabaseQueries.getSeatsByFlightId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBooking method, of class DatabaseQueries.
     */
    @Test
    public void testGetBooking() {
        System.out.println("getBooking");
        int id = 0;
        Booking expResult = null;
        Booking result = DatabaseQueries.getBooking(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookings method, of class DatabaseQueries.
     */
    @Test
    public void testGetBookings() {
        System.out.println("getBookings");
        String ssn = "";
        int flightid = 0;
        ArrayList<Booking> expResult = null;
        ArrayList<Booking> result = DatabaseQueries.getBookings(ssn, flightid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingId method, of class DatabaseQueries.
     */
    @Test
    public void testGetBookingId() {
        System.out.println("getBookingId");
        String ssn = "";
        int flightid = 0;
        int expResult = 0;
        int result = DatabaseQueries.getBookingId(ssn, flightid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserBookings method, of class DatabaseQueries.
     */
    @Test
    public void testGetUserBookings() {
        System.out.println("getUserBookings");
        String ssn = "";
        ArrayList<Booking> expResult = null;
        ArrayList<Booking> result = DatabaseQueries.getUserBookings(ssn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class DatabaseQueries.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String ssn = "";
        String username = "";
        String password = "";
        User expResult = null;
        User result = DatabaseQueries.getUser(ssn, username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newUser method, of class DatabaseQueries.
     */
    @Test
    public void testNewUser() {
        System.out.println("newUser");
        String ssn = "";
        String name = "";
        String password = "";
        int expResult = 0;
        int result = DatabaseQueries.newUser(ssn, name, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bookSeats method, of class DatabaseQueries.
     */
    @Test
    public void testBookSeats() {
        System.out.println("bookSeats");
        ArrayList<Booking> bookings = null;
        int expResult = 0;
        int result = DatabaseQueries.bookSeats(bookings);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEncoding method, of class DatabaseQueries.
     */
    @Test
    public void testSetEncoding() {
        System.out.println("setEncoding");
        String encoding = "";
        DatabaseQueries.setEncoding(encoding);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
