/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author greta
 */
public class Utilities {
    
    /**
     * Skilar Date hlut úr streng á forminu yyyy-MM-dd
     * @return 
     */
    public static java.sql.Date getDate(String str) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return new Date((df.parse(str)).getTime());         
    }
}
