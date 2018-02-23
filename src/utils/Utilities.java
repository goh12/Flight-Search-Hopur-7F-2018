/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import static database.DatabaseQueries.getSeatsByFlightId;
import datastructures.Airport;
import datastructures.Flight;
import datastructures.Seat;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author greta
 */
public class Utilities {
    
    /**
     * Skilar Date hlut úr streng á forminu yyyy-MM-dd
     * @return 
     */
    public static java.sql.Date getDate(String str) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return new Date((df.parse(str)).getTime());         
    }
    
    
        /**
     * Tekur inn ResultSet af flugum, og 2 Airport hluti (origin og destination)
     * og býr til ArrayList af Flight hlutum.
     * @param rs
     * @param aOrigin
     * @param aDestination
     * @return  Öllum flugum úr ResultSet rs
     * @throws SQLException 
     */
    public static ArrayList<Flight> listFlights
        (ResultSet rs, Airport aOrigin, Airport aDestination) throws SQLException 
    {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        
        while (rs.next()) {
            int flid = rs.getInt(1);
            ArrayList<Seat> seats = getSeatsByFlightId(flid);
                flights.add(new Flight(
                        flid,
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        aOrigin,
                        aDestination,
                        rs.getInt(7),
                        seats
                ));
            }
        
        return flights;
    }
}
