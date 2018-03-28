/*
 * Petur Sigurdsson, pes14.
 */
package containers;

import datastructures.Flight;
import database.DatabaseQueries;
import java.text.SimpleDateFormat;
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
public class FlightsTest {
    
    public FlightsTest() {
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
     * Test of getAllFlightsToFrom method, of class Flights.
     */
    @Test
    public void testGetAllFlightsToFrom() {
        System.out.println("getAllFlightsToFrom");
        String origin = "";
        String destination = "";
        Flights expResult = null;
        Flights result = Flights.getAllFlightsToFrom(origin, destination);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlightsToFromOnDate method, of class Flights.
     */
    @Test
    public void testGetFlightsToFromOnDate() {
        System.out.println("getFlightsToFromOnDate");
        String origin = "";
        String destination = "";
        Date date = null;
        Flights expResult = null;
        Flights result = Flights.getFlightsToFromOnDate(origin, destination, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFlightsToFromBetweenDates method, of class Flights.
     */
    @Test
    public void testGetFlightsToFromBetweenDates() {
        System.out.println("getFlightsToFromBetweenDates");
        String origin = "Reykjavík";
        String destination = "Akureyri";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date date1 = df.parse("01/01/2018");
            Date date2 = df.parse("31/12/2018");
            ArrayList<Flight> expResult = DatabaseQueries.getFlightsToFromBetweenDates(origin, destination, date1, date2);
            ArrayList<Flight> result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2).getFlights();
            assertEquals(expResult, result);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }

    /**
     * Test of getFlights method, of class Flights.
     */
    @Test
    public void testGetFlights() {
        System.out.println("getFlights");
        Flights instance = Flights.getAllFlightsToFrom("Reyk","");
        // Þarf að athuga í gagnagrunn.
        int expResult = 4;
        int result = instance.getFlights().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of sortFlightsByDate method, of class Flights.
     * Expect ascending order.
     */
    @Test
    public void test1SortFlightsByDate() {
        System.out.println("sortFlightsByDate");
        boolean asc = true;
        Flights instance = Flights.getAllFlightsToFrom("Reyk","");
        Flight first = instance.getFlights().get(0);
        instance.sortFlightsByDate(asc);
        // Notandi ábyrgist að talan sé nógu há.
        long min = Long.MAX_VALUE;
        for(Flight f : instance.getFlights()){
            if(min > f.getDate().getTime() )
                min = f.getDate().getTime();
        }
        Flight sec = instance.getFlights().get(0);
        if(first.equals(sec) && first.getDate().getTime() != min)
            fail("Not sorted.");
    }
    
    /**
     * Test of sortFlightsByDate method, of class Flights.
     * Expect descending order.
     */
    @Test
    public void test2SortFlightsByDate() {
        System.out.println("sortFlightsByDate");
        boolean asc = false;
        Flights instance = Flights.getAllFlightsToFrom("Reyk","");
        Flight first = instance.getFlights().get(0);
        instance.sortFlightsByDate(asc);
        // Notandi ábyrgist að talan sé nógu há.
        long max = 0;
        for(Flight f : instance.getFlights()){
            if(max < f.getDate().getTime() )
                max = f.getDate().getTime();
        }
        Flight sec = instance.getFlights().get(0);
        if(first.equals(sec) && first.getDate().getTime() != max)
            fail("Not sorted.");
    }

    /**
     * Test of sortByPrice method, of class Flights.
     */
    @Test
    public void testSortByPrice() {
        System.out.println("sortByPrice");
        Flights instance = Flights.getAllFlightsToFrom("Reyk","");
        Flight first = instance.getFlights().get(0);
        instance.sortByPrice();
        // Notandi ábyrgist að talan sé nógu há.
        int min = Integer.MAX_VALUE;
        for(Flight f : instance.getFlights()){
            if(min > f.getPrice() )
                min = f.getPrice();
        }
        Flight sec = instance.getFlights().get(0);
        if(first.equals(sec) && first.getPrice()!= min)
            fail("Not sorted.");
    }

    /**
     * Test of sortByLength method, of class Flights.
     * Expect descending order.
     */
    @Test
    public void test1SortByLength() {
        System.out.println("sortByLength");
        boolean asc = false;
        Flights instance = Flights.getAllFlightsToFrom("Reyk","");
        Flight first = instance.getFlights().get(0);
        instance.sortByLength(asc);
        // Notandi ábyrgist að talan sé nógu lág.
        int max = 0;
        for(Flight f : instance.getFlights()){
            if(max < f.getTraveltime())
                max = f.getTraveltime();
        }
        Flight sec = instance.getFlights().get(0);
        if(first.equals(sec) && first.getTraveltime()!= max)
            fail("Not sorted.");
    }
    
     /**
     * Test of sortByLength method, of class Flights.
     * Expect ascending order.
     */
    @Test
    public void test2SortByLength() {
        System.out.println("sortByLength");
        boolean asc = true;
        Flights instance = Flights.getAllFlightsToFrom("Reyk","");
        Flight first = instance.getFlights().get(0);
        instance.sortByLength(asc);
        int min = Integer.MAX_VALUE;
        for(Flight f : instance.getFlights()){
            if(min > f.getTraveltime())
                min = f.getTraveltime();
        }
        Flight sec = instance.getFlights().get(0);
        if(first.equals(sec) && first.getTraveltime()!= min)
            fail("Not sorted.");
    }
    
}
