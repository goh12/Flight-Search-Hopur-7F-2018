/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import database.DatabaseQueries;

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
        this.ssn = ssn.replace("-", "");
        int err = DatabaseQueries.newUser(this.ssn, name);
        if(err == -1) {
            System.out.println("User already exists in database");
        }
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
