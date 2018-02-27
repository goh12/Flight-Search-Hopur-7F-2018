/*
    Klasi heldur utan um bókanir.
    Sér um samband við gagnagrunn.
 */
package containers;

import datastructures.*;
import java.util.ArrayList;
import database.DatabaseQueries;
/**
 *
 * @author greta
 */
public class Bookings {
    private ArrayList<Booking> bookings;
    
    
    public Bookings() {
        bookings = new ArrayList<Booking>();
    }
    
    
    /**
     * Bókar sæti (Notar DatabaseController til að uppfæra gagnagrunn þegar allar
     * bókanir sem notandi vill eru komnar í bookings lista)
     */
    public void bookSeats() {
        DatabaseQueries.bookSeats(bookings);
    }
    
    /**
     * Býr til nýja bókun og bætir í bookings lista.
     */
    public void addBooking(Booking b) {
        bookings.add(b);
    } 
}
