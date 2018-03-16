/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import containers.Flights;
import static database.DatabaseQueries.getSeatsByFlightId;
import datastructures.Airport;
import datastructures.Flight;
import datastructures.Seat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author greta
 */
public class Utilities {
    
    /**
     * Skilar Date hlut úr streng á forminu yyyy-MM-dd
     * @return 
     */
    public static Date getDate(String dateof, String timeof) throws ParseException {
        String temp = dateof + " " + timeof;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new Date((df.parse(temp)).getTime());
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
            try {
                int flid = rs.getInt(1);
                Date time = Utilities.getDate(rs.getString(3), rs.getString(4));
                ArrayList<Seat> seats = getSeatsByFlightId(flid);
                flights.add(new Flight(
                        flid,
                        rs.getString(2),
                        time,
                        aOrigin,
                        aDestination,
                        rs.getInt(7),
                        seats
                ));
            } catch (ParseException ex) {
                Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        return flights;
    }

    public static JTable tableFromFlights(Flights flights) {
        return new JTable(new FlightSearchTableModel(flights));
    }
}
