/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import database.DatabaseController;
import datastructures.Flight;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author greta
 */
public class Flights {
    private final ArrayList<Flight> flights;
    
    private Flights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    /**
     * Nær í öll flug frá milli tveggja flugvalla.
     * @param origin Fararstaður
     * @param destination Komustaður
     * @return 
     */
    public static Flights getAllFlightsToFrom(String origin, String destination) 
    {
        ArrayList<Flight> flights = DatabaseController.getFlightsToFrom(
                origin, destination
        );
        return new Flights(flights);
    }
    
    /**
     * Nær í öll flug frá origin, til destination á dagsetningu date
     * @param origin Fararstaður
     * @param destination Komustaður
     * @param date Dagsetning
     * @return 
     */
    public static Flights getFlightsToFromOnDate(
            String origin, String destination, Date date) 
    {
        ArrayList<Flight> flights = DatabaseController.getFlightsToFromOnDate(
            origin, destination, date
        );
        return new Flights(flights);
    }
    
    /**
     * Nær í öll flug á tímabili milli date1 og date2 (inclusive) frá
     * origin til destination
     * @param origin Fararstaður
     * @param destination komustaður
     * @param date1 dagsetning 1
     * @param date2 dagsetning 2
     * @return 
     */
    public static Flights getFlightsToFromBetweenDates(
            String origin, String destination, Date date1, Date date2) 
    {
        ArrayList<Flight> flights = DatabaseController.getFlightsToFromBetweenDates(
            origin, destination, date1, date2
        );
        return new Flights(flights);
    }
    
    /**
     * Skilar listanum yfir flugin sem Flights hlutur inniheldur.
     * @return 
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }
    
    /**
     * Raðar flugum eftir dagsetningu.
     * @param asc 
     */
    public void sortFlightsByDate() {
        
    }
    
    /**
     * Raðar flugum eftir verði
     */
    public void sortByPrice() {
        
    }
        
}
