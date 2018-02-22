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
public class Booking {
    private final int id; //Id bókunar
    private final String ssn;  //Ssn notanda sem á bókun
    private final int flightId; //id bókunar í gagnagrunni
    private final String seatId; //id sætis í flugvél
    
    /**
     * Smiður
     * @param flightId
     * @param ssn 
     */
    public Booking(int id, String ssn, int flightId, String seatId) {
        this.id = id;
        this.ssn = ssn;
        this.flightId = flightId;
        this.seatId = seatId;
    }

    public int getId() {
        return id;
    }

    public String getSsn() {
        return ssn;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getSeatId() {
        return seatId;
    }

    
    
}
