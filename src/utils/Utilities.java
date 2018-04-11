/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controllers.Flights;
import static database.DatabaseQueries.getSeatsByFlightId;
import datastructures.Airport;
import datastructures.Booking;
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
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author greta
 */
public class Utilities {
    
    /**
     * Skilar Date hlut úr streng á forminu yyyy-MM-dd
     * @param dateof
     * @param timeof
     * @return 
     * @throws java.text.ParseException 
     */
    public static Date getDate(String dateof, String timeof) throws ParseException {
        String temp = dateof + " " + timeof;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new Date((df.parse(temp)).getTime());
    }
    
    
        /**
     * Tekur inn ResultSet af flugum
     * og býr til ArrayList af Flight hlutum.
     * @param rs
     * @return  Öllum flugum úr ResultSet rs
     * @throws SQLException 
     */
    public static ArrayList<Flight> listFlights
        (ResultSet rs) throws SQLException 
    {
        ArrayList<Flight> flights = new ArrayList<>();
        
        while (rs.next()) {
            try {
                int flid = rs.getInt(1);
                Date time = Utilities.getDate(rs.getString(3), rs.getString(4));
                ArrayList<Seat> seats = getSeatsByFlightId(flid);
                Airport aOrigin = new Airport(rs.getString(5));
                Airport aDestination = new Airport(rs.getString(6));
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
        JTable table = new JTable(new FlightSearchTableModel(flights));
        
        //Miðja texta
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        for(int x=0;x<5;x++){   
         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        
        return table;
    }
    
    public static JTable tableFromBookings(ArrayList<Booking> bookings) {
        JTable table = new JTable(new MyBookingsTableModel(bookings));
        
        //Miðja texta
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        for(int x=0;x<4;x++){   
         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        
        return table;
    }
}
