/*
 * Petur Sigurdsson, pes14.
 */
package containers;

import datastructures.Flight;
import database.DatabaseQueries;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Date date1, date2;
    Flights instance;
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
        instance = Flights.getAllFlightsToFrom("Reyk","");
        try{
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            date1 = df.parse("01/01/2018");
            date2 = df.parse("31/12/2018");
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() {
        date1 = null;
        date2 = null;
        instance = null;
    }

    /**
     * Test of getFlightsToFromBetweenDates method, of class Flights.
     */
    @Test
    public void testGetFlightsToFromBetweenDates1() {
        System.out.println("getFlightsToFromBetweenDates");
        String origin = "Reykjavík";
        String destination = "Akureyri";
        
        ArrayList<Flight> expResult = DatabaseQueries.getFlightsToFromBetweenDates(origin, destination, date1, date2);
        ArrayList<Flight> result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2).getFlights();
        for(int i = 0; i < result.size(); i++){
            Flight exp = expResult.get(i);
            Flight r = result.get(i);
            if(exp.getId()!=r.getId())
                fail("Flug "+exp+" og "+r+" eru ekki eins");
        }
    }

    /**
     * Test of getFlights method, of class Flights.
     */
    @Test
    public void testGetFlights() {
        System.out.println("getFlights");
        ArrayList<Flight> result = instance.getFlights();
        ArrayList<Flight> expResult = DatabaseQueries.getFlightsToFrom("Reyk","");
        for(int i = 0; i < result.size(); i++){
                Flight exp = expResult.get(i);
                Flight r = result.get(i);
                if(exp.getId()!=r.getId())
                    fail("Flug "+exp+" og "+r+" eru ekki eins");
        }
    }

    /**
     * Test of sortFlightsByDate method, of class Flights.
     * Expect ascending order.
     */
    @Test
    public void test1SortFlightsByDate() {
        System.out.println("sortFlightsByDate");
        boolean asc = true;
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
        Flight first = instance.getFlights().get(0);
        instance.sortFlightsByDate(asc);
        // Notandi ábyrgist að talan sé nógu lág.
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

    /**
     * Test of getFlightsBetweenDates method, of class Flights.
     */
    @Test
    public void testGetFlightsToFromBetweenDates2() {
        System.out.println("getFlightsBetweenDates");
        String origin = "";
        String destination = "";
        date1 = null;
        date2 = null;
        Flights expResult = null;
        Flights result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlightsToBetweenDates method, of class Flights.
     */
    @Test
    public void testGetFlightsToFromBetweenDates3() {
        try {
            System.out.println("getFlightsToBetweenDates");
            String destination = "Egils";
            String origin = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            date1 = df.parse("01/01/2018");
            date2 = df.parse("31/12/2018");
            ArrayList<Flight> result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2).getFlights();
            ArrayList<Flight> expResult = DatabaseQueries.getFlightsToFromBetweenDates(origin, destination, date1, date2);
            for(int i = 0; i < result.size(); i++){
                Flight exp = expResult.get(i);
                Flight r = result.get(i);
                if(exp.getId()!=r.getId())
                    fail("Flug"+exp+"og"+r+"eru ekki eins");
            }
        } catch (ParseException ex) {
            Logger.getLogger(FlightsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of getFlightsToBetweenDates method, of class Flights.
     */
    @Test
    public void testGetFlightsToFromBetweenDates4() {
        System.out.println("getFlightsToBetweenDates");
        String destination = "";
        String origin = "";
        date1 = null;
        date2 = null;
        Flights expResult = null;
        Flights result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlightsFromBetweenDates method, of class Flights.
     */
    @Test
    public void testGetFlightsToFromBetweenDates5() {
        try {
            System.out.println("getFlightsToFromBetweenDates");
            String origin = "Reykjavík";
            String destination = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            date1 = df.parse("01/01/2018");
            date2 = df.parse("02/02/2018");
            
            
            ArrayList<Flight> result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2).getFlights();
            ArrayList<Flight> expResult = DatabaseQueries.getFlightsFromBetweenDates(origin, date1, date2);
            assertEquals(expResult, result);
        } catch (ParseException ex) {
            Logger.getLogger(FlightsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Test of getFlightsFromBetweenDates method, of class Flights.
     */
    @Test(expected=NullPointerException.class)
    public void testGetFlightsToFromBetweenDates6() {
        try {
            System.out.println("getFlightsToFromBetweenDates");
            String origin = null;
            String destination = null;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            date1 = df.parse("01/01/2018");
            date2 = df.parse("31/12/2018");
            
            
            ArrayList<Flight> result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2).getFlights();
            ArrayList<Flight> expResult = null;
            assertEquals(expResult, result);
        } catch (ParseException ex) {
            Logger.getLogger(FlightsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Test of getFlightsFromBetweenDates method, of class Flights.
     * @throws java.text.ParseException
     */
    @Test
    public void testGetFlightsToFromBetweenDates7() throws ParseException {
            System.out.println("getFlightsToFromBetweenDates");
            String origin = "";
            String destination = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            // fyrri dagsetning seinni en seinni dagsetning
            date1 = df.parse("31/12/2018");
            date2 = df.parse("01/12/2018");
            
            int result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2).getFlights().size();
            int expResult = 0;
            assertEquals(expResult, result);
    }


    /**
     * Test of getFlightsFromBetweenDates method, of class Flights.
     * @throws java.text.ParseException
     */
    @Test(expected=ParseException.class)
    public void testGetFlightsToFromBetweenDates8() throws ParseException {
            System.out.println("getFlightsToFromBetweenDates");
            String origin = "";
            String destination = "";
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            // fyrri dagsetning seinni en seinni dagsetning
            date1 = df.parse("01/12/2018");
            date2 = df.parse("01/12/villa");
            System.out.println(date2);
            
            int result = Flights.getFlightsToFromBetweenDates(origin, destination, date1, date2).getFlights().size();
            int expResult = 0;
            assertEquals(expResult, result);
    }    
}
