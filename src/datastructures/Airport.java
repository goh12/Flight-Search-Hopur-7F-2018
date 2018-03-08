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
    private final int id;       //id flugvallar í gagnagrunni
    
    /**
     * Constructor
     * @param id
     * @param airportname 
     */
    public Airport(int id, String airportname) {
        this.id = id;
        this.name = airportname;
    }

    /**
     * Skilar nafni flugvallar
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Skilar id flugvallar
     * @return 
     */
    public int getId() {
        return id;
    }
    
    public String toString() {
        return name;
    }
    
    
}
