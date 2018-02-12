/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.sql.Date;

/**
 *
 * @author greta
 */
public class Flight {
    
    /*
        Dálkar flugs í gagnagrunni
    */
    private int id;
    private String flno;
    private Date dateof;
    private String timeof;
    private int originId;
    private String originName;
    private int destinationId;
    private String destinationName;
    private int traveltime;
    

    public Flight(int id, String flno, Date dateof, String timeof,
            int originId, String originName, int destinationId, String destinationName,
            int traveltime)
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

    
    
    
}
