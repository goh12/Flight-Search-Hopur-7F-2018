/*
    Klasi heldur utan um eina bókun. 
*/
package datastructures;

import database.DatabaseQueries;

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
     * @param id
     * @param flightId
     * @param ssn 
     * @param seatId 
     */
    public Booking(int id, String ssn, int flightId, String seatId) {
        this.id = id;
        this.ssn = ssn;
        this.flightId = flightId;
        this.seatId = seatId;
    }
    
    /**
     * Smiður
     * @param flightId
     * @param ssn 
     * @param seatId 
     */
    public Booking(String ssn, int flightId, String seatId) {
        this.id = -1;
        this.ssn = ssn;
        this.flightId = flightId;
        this.seatId = seatId;
    }
    
    /**
     * Smiður
     * @param ssn 
     * @param seat 
     */
    public Booking(String ssn, Seat seat) {
        this.id = DatabaseQueries.getBookingId(ssn, seat.getFlightId());
        this.ssn = ssn;
        this.flightId = seat.getFlightId();
        this.seatId = seat.getSeatId();
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
        
    @Override
    public String toString() {
        return ssn + " á sæti " + seatId + " í flugi " + flightId;
    }

}
