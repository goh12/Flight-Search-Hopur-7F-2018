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
public class User {
    
    private final String ssn; // kennitala notanda
    private final String name; // nafn notanda
    
    /**
     * smiður
     * @param ssn
     * @param name 
     */
    public User(String ssn, String name){
        this.name = name;
        this.ssn = ssn;
    }
    
    /**
     * Skilar nafni notanda
     * @return 
     */
    public String getName(){
        return name;
    }
    
    /**
     * skilar kennitölu notanda
     * @return  
     */
    public String getSsn() {
        return ssn;
    }
    
}
