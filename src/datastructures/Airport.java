/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author greta
 */
public class Airport {
    private final String name;  //Nafn flugvallar
    
    /**
     * Constructor
     * @param airportname 
     */
    public Airport(String airportname) {
        this.name = airportname;
    }

    /**
     * Skilar nafni flugvallar
     * @return 
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
