/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author greta
 */
public class Flight {
    
    /*
        Dálkar flugs í gagnagrunni
    */
    private final int id;                   //ID flugs í db
    private final String flno;              //Flugnúmer
    private final Date dateof;              //Dagsetning flugs
    private final String timeof;            //Tími flugs
    private final Airport origin;
    private final Airport destination;
    private final int traveltime;           //Ferðatími
    private final ArrayList<Seat> seats;    //Sæti í flugi
    

    public Flight(int id, String flno, Date dateof, String timeof,
            Airport origin, Airport destination,
            int traveltime, ArrayList<Seat> seats)
    {
        this.id = id;
        this.flno = flno;
        this.dateof = dateof;
        this.timeof = timeof;
        this.origin = origin;
        this.destination = destination;
        this.traveltime = traveltime;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public String getFlno() {
        return flno;
    }

    public Date getDateof() {
        return dateof;
    }

    public String getTimeof() {
        return timeof;
    }


    public int getTraveltime() {
        return traveltime;
    }
    
    public ArrayList<Seat> getSeats() {
        return seats;
    }
    
    /**
     * Skilar fjölda lausra sæta í flugi
     * @return 
     */
    public int availableSeats() {
        int i = 0;
        for (Seat s : seats) {
            if (!s.isBooked()) i++;
        }
        
        return i;
    }
    
    /**
     * Skilar verði fyrir sæti í flugi.
     * @return 
     */
    public int getPrice() {
        //TODO
        return 0;
    }
    
    
    public String toString() {
        return origin.toString() + " til " + destination.toString() + ". " 
                + dateof.toString() + " kl. " + timeof;
    }
    
}
