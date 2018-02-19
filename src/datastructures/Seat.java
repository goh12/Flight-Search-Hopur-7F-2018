/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author gudmu
 */
public class Seat {
    private final int seats;  // heildarfjöldi sæta í gagnagrunni
    private final int flightId; // id bókunar í gagnagrunni
    private final int booked; // fjöldi booked í gagnagrunni
    
    /**
     * Smiður
     * @param flightId
     * @param seats
     * @param booked 
     */
    public Seat(int flightId, int seats, int booked) {
        this.booked = booked;
        this.seats = seats;
        this.flightId = flightId;
    }
    
    /**
     * skilar fjölda sæta
     * @return
     */
    public int getSeats() {
        return seats;
    }
    
    /**
     * skilar id flugs
     * @return  
     */
    public int getFlightId() {
        return flightId;
    }
    
    /**
     * skilar fjölda bókaðra sæta
     * @return 
     */
    public int getBooked() {
        return booked;
    }
    
    
}
