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
    private final String ssn;  //Ssn notanda sem á bókun
    private final int flightId; //id bókunar í gagnagrunni
    
    /**
     * Smiður
     * @param flightId
     * @param ssn 
     */
    public Booking(int flightId, String ssn) {
        this.flightId = flightId;
        this.ssn = ssn;
    }

    /**
     * 
     * @return skilar kennitölu notanda
     */
    public String getSsn() {
        return ssn;
    }
    
    /**
     * 
     * @return skilar id flugs
     */
    public int getFlightId() {
        return flightId;
    }
    
    
}
