/*
    Klasi sem heldur utan um eitt sæti í einu flugi.
*/
package datastructures;

/**
 *
 * @author gudmu
 */
public class Seat {
    private final int flightId; // id bókunar í gagnagrunni
    private final String seatId;  // heildarfjöldi sæta í gagnagrunni
    private boolean booked; // fjöldi booked í gagnagrunni
    
    /**
     * Smiður
     * @param flightId
     * @param seatId
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
    
    public void setBooked() {
        booked = true;
    }
    
    @Override
    public String toString() {
        return "Sæti: " + seatId + ". Í flugi: " + flightId;
    }
    
    
}
