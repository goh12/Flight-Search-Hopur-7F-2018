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
    private final int flightId; // id bókunar í gagnagrunni
    private final String seatId;  // heildarfjöldi sæta í gagnagrunni
    private final boolean booked; // fjöldi booked í gagnagrunni
    
    /**
     * Smiður
     * @param flightId
     * @param seats
     * @param booked 
     */
    public Seat(int flightId, String seatId, boolean booked) {
        this.booked = booked;
        this.seatId = seatId;
        this.flightId = flightId;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getSeatId() {
        return seatId;
    }

    public boolean isBooked() {
        return booked;
    }
    
    
}
