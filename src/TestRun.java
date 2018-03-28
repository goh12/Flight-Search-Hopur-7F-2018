
import containers.Flights;
import containers.Bookings;
import database.DatabaseQueries;
import datastructures.Flight;
import datastructures.Booking;
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
            
            System.out.println();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse("2018-05-06");
            
            System.out.println();
            Date d1 = sdf.parse("2018-01-11");
            Date d2 = sdf.parse("2019-09-23");
            Flights flightsBDate = Flights.getFlightsToFromBetweenDates("Reykjavík", "Akureyri", d1,d2);
            
            for(Flight f : flightsBDate.getFlights()) {
                System.out.println(f);
                System.out.println(f.getPrice());
            }
            System.out.println();
            flightsBDate.sortByPrice();
            
            for(Flight f : flightsBDate.getFlights()) {
                System.out.println(f);
                System.out.println(f.getPrice());
            }
            System.out.println();
            
            flightsBDate.sortFlightsByDate(true);
            for(Flight f : flightsBDate.getFlights()) {
                System.out.println(f);
                System.out.println(f.getPrice());
            }
            System.out.println();
            
            flightsBDate.sortFlightsByDate(false);
            for(Flight f : flightsBDate.getFlights()) {
                System.out.println(f);
                System.out.println(f.getPrice());
            }
            System.out.println();
            
            Flight flight = flightsBDate.getFlights().get(0);
            
            
            User petur = new User("2604823199","Petur","123456");
            Booking bkn = new Booking(petur.getSsn(),flight.getId(),flight.getSeats().get(0).getSeatId());
            Bookings bkns = new Bookings();
            bkns.addBooking(bkn);
            bkns.bookSeats();
    }
}
