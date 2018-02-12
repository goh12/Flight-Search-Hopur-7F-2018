/*
    Klasi sem býr til föll til að halda utan um allar GENERIC queries.
    Búa til public föll fyrir eitthvað query og private föll til
    hjálpar ef þarf.
*/
package database;

import database.DatabaseConnection.*;
import datastructures.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author greta
 */
public class DatabaseQueries {
    private DatabaseQueries() {}
    
    /**
     * Finnur flugvöll með nafni í gagnagrunn og skilar honum
     * @param airportname
     * @return new Airport
     * @throws SQLException 
     */
    private static Airport getAirportByName(String airportname) throws SQLException {
        int id;
        String name;
        String q = "SELECT id, airportname FROM airports WHERE lower(airportname) LIKE lower(?)";
        ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);

        cpst.pst.setString(1, airportname);
        ResultSet rs =  cpst.pst.executeQuery();
        
        rs.next();
        id = rs.getInt(1);  
        name = rs.getString(2);
        
        cpst.close();

        return new Airport(id, name);
    }
    
    /**
     * Finnur öll flug frá flugvelli origin til flugvallar destination.
     * @param origin nafn á flugvelli origin
     * @param destination nafn á flugvelli destination
     */
    public static void getAllFlightsToFrom(String originName, String destinationName) {
        try {
            Airport origin = getAirportByName(originName);
            Airport destination = getAirportByName(destinationName);
            
            String q = "SELECT dateof, timeof FROM flights WHERE origin = ? AND destination = ?";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setInt(1, origin.getId());
            cpst.pst.setInt(2, destination.getId());
            ResultSet rs =  cpst.pst.executeQuery();
            
            while (rs.next()) {
                System.out.printf("%s, %s\n", rs.getString(1), rs.getString(2));
            }
            
            cpst.close();      
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Finnur flug frá origin til destination á gefnum degi date.
     * @param origin
     * @param destination
     * @param date 
     */
    public static ArrayList<Flight> getFlightsToFromOnDate(
            String origin, String destination, Date date) {
        
        ArrayList<Flight> flights = null;
        try {
            flights = new ArrayList<Flight>();
            Airport aOrigin = getAirportByName(origin);
            Airport aDestination = getAirportByName(destination);
            
            String q = 
                    "SELECT id, flno, dateof, timeof, origin, destination, traveltime from flights WHERE "
                    + "origin = ? AND destination = ? AND dateof = ?";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setInt(1, aOrigin.getId());
            cpst.pst.setInt(2, aDestination.getId());
            cpst.pst.setDate(3, date);
            
            ResultSet rs = cpst.pst.executeQuery();
            while (rs.next()) {
                flights.add(new Flight(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5),
                        aOrigin.getName(),
                        rs.getInt(6),
                        aDestination.getName(),
                        rs.getInt(7)
                ));
            }
                        
            return flights;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return flights;
    }
    
    
    /**
     * Gefur flug frá origin til destination milli gefnra dagsetninga
     * dateFirst og dateLast
     * @param origin
     * @param destination
     * @param dateFirst
     * @param dateLast 
     */
    public static ArrayList<Flight> getFlightsToFromBetweenDates(
            String origin, String destination, Date dateFirst, Date dateLast) {
        
        ArrayList<Flight> flights = null;
        try {
            flights = new ArrayList<Flight>();
            Airport aOrigin = getAirportByName(origin);
            Airport aDestination = getAirportByName(destination);
             
            String q = 
                    "SELECT id, flno, dateof, timeof, origin, destination, traveltime from flights WHERE "
                    + "origin = ? AND destination = ? AND dateof >= ? AND dateof <= ?";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setInt(1, aOrigin.getId());
            cpst.pst.setInt(2, aDestination.getId());
            cpst.pst.setDate(3, dateFirst);
            cpst.pst.setDate(4, dateLast);
            
            ResultSet rs = cpst.pst.executeQuery();
            while (rs.next()) {
                flights.add(new Flight(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5),
                        aOrigin.getName(),
                        rs.getInt(6),
                        aDestination.getName(),
                        rs.getInt(7)
                ));
            }
            
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return flights;
    }
    
}
