/*
    Klasi sem býr til föll til að halda utan um allar GENERIC queries.
    Búa til public föll fyrir eitthvað query og private föll til
    hjálpar ef þarf.
*/


/*
    Queries sem við þurfum að IMPLEMENTA! (hjálparföll ekki innifalin)
    getAirports() --> DONE
    getAirportByName(String name) --> DONE
    getAirportById(String id) --> DONE

    getFlightsFromTo(String origin, String destination) --> DONE
    getFlightsFromToOnDate(String origin, String destination, Date date) --> DONE
    getFlightsFromToBetweenDates(String origin, String destination, Date date1, Date date2) --> DONE
    
    getFlightById(int id)

    getBooking(String ssn, flightId)
    getUserBookings(String ssn)
    
    getUser(String ssn)

    getAvailableSeats(flightId)
*/
package database;

import database.DatabaseConnection.*;
import datastructures.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * Finnur flugvöll með id í gagnagrunn og skilar honum
     * @param airportname 
     * @return new Airport
     * @throws SQLException 
     */
    private static Airport getAirportById(int id) {
        try {
           String name;
            String q = "SELECT id, airportname FROM airports WHERE id = ?)";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);

            cpst.pst.setInt(1, id);
            ResultSet rs =  cpst.pst.executeQuery();

            rs.next();
            name = rs.getString(2);

            cpst.close();

            return new Airport(id, name);  
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static ArrayList<Airport> getAirports() {
        ArrayList<Airport> airports = null;
        try {
            airports = new ArrayList<Airport>();
            String q = "SELECT id, airportname FROM airports";
            ConnectionStatement cst = new ConnectionStatement();
            
            ResultSet rs = cst.st.executeQuery(q);
            
            while(rs.next()) {
                airports.add(new Airport(
                    rs.getInt(1),
                    rs.getString(2)
                ));
            }
            rs.close();
            cst.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return airports;
    }
    
    /**
     * Finnur öll flug frá flugvelli origin til flugvallar destination.
     * @param origin nafn á flugvelli origin.
     * @param destination nafn á flugvelli destination
     */
    public static ArrayList<Flight> getFlightsToFrom(String originName, String destinationName) {
        ArrayList<Flight> flights = null;
        try {            
            Airport aOrigin = getAirportByName(originName);
            Airport aDestination = getAirportByName(destinationName);
            
            String q = "SELECT id, flno, dateof, timeof, origin, destination, traveltime FROM flights WHERE origin = ? AND destination = ? "
                    + "ORDER BY dateof, timeof";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setInt(1, aOrigin.getId());
            cpst.pst.setInt(2, aDestination.getId());
            
            ResultSet rs =  cpst.pst.executeQuery();
            flights = listFlights(rs, aOrigin, aDestination);
            
            rs.close();
            cpst.close();      
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return flights;
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
            Airport aOrigin = getAirportByName(origin);
            Airport aDestination = getAirportByName(destination);
            
            String q = 
                    "SELECT id, flno, dateof, timeof, origin, destination, traveltime from flights WHERE "
                    + "origin = ? AND destination = ? AND dateof = ? "
                    + "ORDER BY dateof, timeof";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setInt(1, aOrigin.getId());
            cpst.pst.setInt(2, aDestination.getId());
            cpst.pst.setDate(3, date);
            
            ResultSet rs = cpst.pst.executeQuery();
            flights = listFlights(rs, aOrigin, aDestination);
            rs.close();
            cpst.close();
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
                    + "origin = ? AND destination = ? AND dateof >= ? AND dateof <= ? "
                    + "ORDER BY dateof, timeof";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setInt(1, aOrigin.getId());
            cpst.pst.setInt(2, aDestination.getId());
            cpst.pst.setDate(3, dateFirst);
            cpst.pst.setDate(4, dateLast);
            
            ResultSet rs = cpst.pst.executeQuery();
            flights = listFlights(rs, aOrigin, aDestination);
            
            rs.close();
            cpst.close();
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return flights;
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
    private static ArrayList<Flight> listFlights
        (ResultSet rs, Airport aOrigin, Airport aDestination) throws SQLException 
    {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        
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
    }
    
}
