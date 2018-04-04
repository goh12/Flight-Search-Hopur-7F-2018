/*
    Klasi heldur utan um bókanir.
    Sér um samband við gagnagrunn.
 */
package controllers;

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
        bookings = new ArrayList<>();
    }
    
    /**
     * þessi smiður er ef bókanir eru til á notanda
     * @param existingBookings 
     */
    public Bookings(ArrayList<Booking> existingBookings) {
        this.bookings = existingBookings;
    }
    /**
     * Bókar sæti (Notar DatabaseController til að uppfæra gagnagrunn þegar allar
     * bókanir sem notandi vill eru komnar í bookings lista)
     * @return 
     */
    public int bookSeats() {
        if (DatabaseQueries.bookSeats(bookings) == 0) return 0;
        return -1;
    }
    
    /**
     * Býr til nýja bókun og bætir í bookings lista.
     * @param b
     */
    public void addBooking(Booking b) {
        bookings.add(b);
    } 
    
    public ArrayList<Booking> getBookings() {
        return this.bookings;
    }
    
    public void getAllBookingsForSSN() {
        //Database call for bookings
        //return all bookings
    }
}
