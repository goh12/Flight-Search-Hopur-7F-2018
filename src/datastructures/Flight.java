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
    private final int id;
    private final String flno;
    private final Date dateof;
    private final String timeof;
    private final int originId;
    private final String originName;
    private final int destinationId;
    private final String destinationName;
    private final int traveltime;
    private final ArrayList<Seat> seats;
    

    public Flight(int id, String flno, Date dateof, String timeof,
            int originId, String originName, int destinationId, String destinationName,
            int traveltime, ArrayList<Seat> seats)
    {
        this.id = id;
        this.flno = flno;
        this.dateof = dateof;
        this.timeof = timeof;
        this.originId = originId;
        this.originName = originName;
        this.destinationId = destinationId;
        this.destinationName = destinationName;
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

    public int getOriginId() {
        return originId;
    }

    public String getOriginName() {
        return originName;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public int getTraveltime() {
        return traveltime;
    }
    
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    
    
    
}
