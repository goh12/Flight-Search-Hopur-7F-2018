/*
    Klasi heldur utan um alla flugvelli.
    Fínt að hafa alla flugvelli í einum hlut.
    Sér um samband við gagnagrunn.
*/
package containers;

import database.DatabaseController;
import datastructures.Airport;
import java.util.ArrayList;

/**
 *
 * @author greta
 */
public class Airports {
    private final ArrayList<Airport> airports;
    
    public Airports() {
        airports = DatabaseController.getAirports();
    }
}
