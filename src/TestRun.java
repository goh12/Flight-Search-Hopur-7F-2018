
import containers.Flights;
import database.DatabaseQueries;
import datastructures.Flight;
import datastructures.Seat;
import datastructures.User;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import utils.Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author greta
 */
public class TestRun {
    public static void main(String[] args) throws ParseException {
            Flights flights = Flights.getAllFlightsToFrom("Reykjavík", "Akureyri");
            
            for(Flight f : flights.getFlights()) {
                System.out.println(f);
            }
           
        
    }
}
