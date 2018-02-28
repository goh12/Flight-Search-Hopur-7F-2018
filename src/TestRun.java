
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
            
            System.out.println();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2018-05-23");
            Flights flightsOnDate = Flights.getFlightsToFromOnDate("Reykjavík", "Akureyri", d);
            
            for(Flight f : flightsOnDate.getFlights()) {
                System.out.println(f);
            }
            
            System.out.println();
            Date d1 = sdf.parse("2018-03-11");
            Date d2 = sdf.parse("2018-05-23");
            Flights flightsBDate = Flights.getFlightsToFromBetweenDates("Reykjavík", "Akureyri", d1,d2);
            
            for(Flight f : flightsBDate.getFlights()) {
                System.out.println(f);
            }

    }
}
