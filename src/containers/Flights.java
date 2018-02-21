/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import database.DatabaseQueries;
import datastructures.Flight;
import java.util.ArrayList;
/**
 *
 * @author greta
 */
public class Flights {
    private final ArrayList<Flight> flights;
    
    public Flights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    public static Flights getAllFlightsToFrom(String origin, String destination) {
        ArrayList<Flight> flights = DatabaseQueries.getFlightsToFrom(origin, destination);
        return new Flights(flights);
    }
    
    /**
     * 
     * @param asc 
     */
    public void sortFlightsByDate() {
        
    }
    
    public void sortByPrice() {
        
    }
        
}
