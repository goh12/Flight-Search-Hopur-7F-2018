/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    private final Date date;
    //private final Date dateof;              //Dagsetning flugs
    //private final String timeof;            //Tími flugs
    private final Airport origin;
    private final Airport destination;
    private final int traveltime;           //Ferðatími
    private final ArrayList<Seat> seats;    //Sæti í flugi
    

    public Flight(int id, String flno, Date date,
            Airport origin, Airport destination,
            int traveltime, ArrayList<Seat> seats)
    {
        this.id = id;
        this.flno = flno;
        this.date = date;
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

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }
    
    
    
    /**
     * Skilar verði fyrir sæti í flugi.
     * @return 
     */
    public int getPrice() {
        Date now = new Date();
        long timeBetween = date.getTime() - now.getTime();
        timeBetween = timeBetween/1000;
        timeBetween = timeBetween / (60 * 60 * 24);
        int cost = 15000 + 10000/Math.max((int) timeBetween, 1) + 10000 - (availableSeats() * 150);
        
        return cost;
    }
    
    public Date getDate() {
        return date;
    }
    
    
    @Override
    public String toString() {
        return origin.toString() + " til " + destination.toString() + ". " +
                date.toString();
    }
    
    
    public void orderSeats() {
        Collections.sort(this.seats, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                String regex = "[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])";
                Seat s1 = (Seat) o1;
                Seat s2 = (Seat) o2;
                String[] split1 = s1.getSeatId().split(regex);
                String[] split2 = s2.getSeatId().split(regex);
                
                Integer i1 = Integer.parseInt(split1[0]);
                Integer i2 = Integer.parseInt(split2[0]);
                int sComp = i1.compareTo(i2);
                if (sComp != 0) {
                    return sComp;
                } else {
                    return split1[1].compareTo(split2[1]);
                }
            }
        });
    }
    
}
