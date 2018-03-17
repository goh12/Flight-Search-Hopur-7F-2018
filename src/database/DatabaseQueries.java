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
    getFlightById(int id) --> DONE

    getBooking(String ssn, flightId) --> Skoda
    getUserBookings(String ssn)
    bookSeats(ArrayList<Booking> bookings)--> Skoda

    getUser(String ssn)
    newUser(String ssn, String name)
    
    

*/
package database;

import database.DatabaseController.*;
import datastructures.*;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utilities;

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
    private static Airport getAirportByName(String airportname) throws SQLException, Exception {
        String name = null;
        String q = "SELECT airportname FROM airports WHERE lower(airportname) LIKE lower(?)";
        ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);

        cpst.pst.setString(1, "%"+airportname+"%");
        ResultSet rs =  cpst.pst.executeQuery();
        if (rs.next()) {
            name = rs.getString(1);
        }
        
        cpst.close();
        if(name == null) throw new Exception("Airport not found");
        return new Airport(name);
    }
    
    
    public static ArrayList<Airport> getAirports() {
        ArrayList<Airport> airports = null;
        try {
            airports = new ArrayList<Airport>();
            String q = "SELECT airportname FROM airports";
            ConnectionStatement cst = new ConnectionStatement();
            
            ResultSet rs = cst.st.executeQuery(q);
            
            while(rs.next()) {
                airports.add(new Airport(
                    rs.getString(1)
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
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            
            cpst.pst.setString(1, aOrigin.getName());
            cpst.pst.setString(2, aDestination.getName());
            
            ResultSet rs =  cpst.pst.executeQuery();
            flights = Utilities.listFlights(rs, aOrigin, aDestination);
            
            rs.close();
            cpst.close();      
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            return null;
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
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            
            cpst.pst.setString(1, aOrigin.getName());
            cpst.pst.setString(2, aDestination.getName());
            cpst.pst.setDate(3, new java.sql.Date(date.getTime()));
            
            ResultSet rs = cpst.pst.executeQuery();
            flights = Utilities.listFlights(rs, aOrigin, aDestination);
            rs.close();
            cpst.close();
            return flights;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseQueries.class.getName()).log(Level.SEVERE, null, ex);
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
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            
            cpst.pst.setString(1, aOrigin.getName());
            cpst.pst.setString(2, aDestination.getName());
            cpst.pst.setDate(3, new java.sql.Date(dateFirst.getTime()));
            cpst.pst.setDate(4, new java.sql.Date(dateLast.getTime()));
            
            ResultSet rs = cpst.pst.executeQuery();
            flights = Utilities.listFlights(rs, aOrigin, aDestination);
            
            rs.close();
            cpst.close();
            return flights;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            return null;
        }
        
        return flights;
    }
    
    
    /**
     * Finnur Flight í gagnagrunni með id og skilar sem flight hlut.
     * @param id id Flugs í gagnagrunni
     * @return Flight object með viðeigandi id
     */
    public static Flight getFlightsById(int id) {
        try {
            Flight flight = null;
             
            String q = 
                    "SELECT f1.id, flno, dateof, timeof, origin, destination, traveltime "
                    + "WHERE f1.id = ?";
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            cpst.pst.setInt(1, id);
            ResultSet rs = cpst.pst.executeQuery();
            
            
            if(rs.next()) {
                int flid = rs.getInt(1);
                Date time = Utilities.getDate(rs.getString(3), rs.getString(4));
                ArrayList<Seat> seats = getSeatsByFlightId(flid);
                flight = new Flight(
                        rs.getInt(1),
                        rs.getString(2),
                        time,
                        new Airport(rs.getString(5)),
                        new Airport(rs.getString(6)),
                        rs.getInt(7),
                        seats
                );
            }
            
            
            rs.close();
            cpst.close();
            return flight;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(DatabaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
        
    /**
     * Nær í öll sæti í flugi með ID
     * @param id ID flugs í gagnagrunni
     * @return nýjum lista yfir sæti í flugi með viðeigandi ID
     */
    public static ArrayList<Seat> getSeatsByFlightId(int id) {
        try {
            ArrayList<Seat> seats = new ArrayList<Seat>();
            String q = "SELECT flightid, seatid, booked FROM seats "
                    + "WHERE flightid = ?";
            
            ConnectionPreparedStatement cpst = new ConnectionPreparedStatement(q);
            cpst.pst.setInt(1, id);
            
            ResultSet rs = cpst.pst.executeQuery();
            while(rs.next()) {
                seats.add(new Seat(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getBoolean(3)
                ));
            }
            
            rs.close();
            cpst.close();
            return seats;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
    
   
    
    //Þarf þess aðferð samt?
    /**
     * Finnur bókun með sama id
     * @param id bókunarid
     * @return 
     */
    public static Booking getBooking(int id) {
        try {
            Booking booking = null;
            
            String q = "SELECT * FROM bookings WHERE id = ?";
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            cpst.pst.setInt(1, id);
            ResultSet rs = cpst.pst.executeQuery();
            
            if(rs.next()) {
                booking = new Booking(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
            }
            
            rs.close();
            cpst.close();
            return booking;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /*
     * Finnur bókun með kennitlolu og flightId. ps
     * @param String ssn kennitala
     * @param int flightid
     * @return 
     */
    public static ArrayList<Booking> getBookings(String ssn, int flightid) {
        try {
            ArrayList<Booking> bookings = new ArrayList<>();
            
            String q = "SELECT * FROM bookings WHERE ssn = ? AND flightid = ?";
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            cpst.pst.setString(1, ssn);
            cpst.pst.setInt(2, flightid);
            ResultSet rs = cpst.pst.executeQuery();
            
            while(rs.next()) {
                bookings.add(new Booking(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                ));
            }
            
            rs.close();
            cpst.close();
            return bookings;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    /**
     * Sækir bókanir sem notandi er skráður fyrir
     * @param ssn kennitala notanda
     * @return 
     */
    public static ArrayList<Booking> getUserBookings(String ssn) {
        try {
            ArrayList<Booking> bookings = new ArrayList<>();
            String q = "SELECT * FROM bookings WHERE ssn = ?";
            
            ConnectionPreparedStatement cpst = new ConnectionPreparedStatement(q);
            cpst.pst.setString(1, ssn);
            
            ResultSet rs = cpst.pst.executeQuery();
            while(rs.next()) {
                bookings.add(new Booking(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3), 
                        rs.getString(4)
                ));
            }
            
            rs.close();
            cpst.close();
            return bookings;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Sækir notanda úr gagnagrunni með sömu kennitölu
     * @param ssn kennitala notanda
     * @return 
     */
    public static User getUser(String ssn) {
        try {
            User user = null;
            
            String q = "SELECT * FROM users WHERE ssn = ?";
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            cpst.pst.setString(1, ssn);
            ResultSet rs = cpst.pst.executeQuery();
            
            if(rs.next()) {
                user = new User(
                        rs.getString(1),
                        rs.getString(2)
                );
            }
            
            rs.close();
            cpst.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Býr til nýan user í gagnagrunn.
     * @param ssn kt notanda
     * @param name nafn notanda
     * @return -1 ef notandi er til, -2 ef óþekkt villa kemur upp, annars 1
     */
    public static int newUser(String ssn, String name) {
        try {
            User user = null;
            
            String q = "INSERT INTO users (ssn, name) VALUES(?, ?)";
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            cpst.pst.setString(1, ssn);
            cpst.pst.setString(2, name);
            
            int executeUpdate = cpst.pst.executeUpdate();
            
            cpst.close();
            return executeUpdate;
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                System.out.println("Seats already booked");
                return -1;
            } else {
                e.printStackTrace();
                return -2;
            }
            //e.printStackTrace();
        }
    }

    /**
     * Uppfærir gagnagrunn með nýjum bókunum
     * @param bookings Bókanir sem þarf að uppfæra gagnagrunn með
     * @return -1 ef sæti er nú þegar bókuð. -2 ef óþekkt villa kom upp,
     * annars 0
     */
    public static int bookSeats(ArrayList<Booking> bookings) {
        try {
            User user = null;
            String q = "INSERT INTO bookings (ssn, flightid, seatid) VALUES(?, ?, ?)";
            ConnectionPreparedStatement cpst = DatabaseController.getConnectionPreparedStatement(q);
            for (Booking b : bookings){
                
                cpst.pst.setString(1, b.getSsn());
                cpst.pst.setInt(2, b.getFlightId());
                cpst.pst.setString(3, b.getSeatId());
                cpst.pst.addBatch();
            }
            cpst.pst.executeBatch();
            cpst.close();
            return 0;
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                System.out.println("Seats already booked");
                return -1;
            } else {
                e.printStackTrace();
                return -2;
            }
        }
        
    }
}
