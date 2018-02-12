
import database.DatabaseQueries;
import datastructures.Flight;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import utils.Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author greta
 */
public class TestRun {
    public static void main(String[] args) throws ParseException {
            DatabaseQueries.getAllFlightsToFrom("Reykjavík", "Akureyri");
            
            Date d1 = Utilities.getDate("2018-05-14");
            Date d2 = Utilities.getDate("2018-07-26");
            
            ArrayList<Flight> flights1 = DatabaseQueries.getFlightsToFromOnDate("Reykjavík", "Akureyri", d1);
            
            flights1.forEach((f) -> {
                System.out.printf("%s to %s - %s at %s\n", f.getOriginName(), f.getDestinationName(), f.getDateof(), f.getTimeof());
            });
                        
            ArrayList<Flight> flights2 = DatabaseQueries.getFlightsToFromBetweenDates("Reykjavík", "Akureyri", d1, d2);
            flights2.forEach((f) -> {
                System.out.printf("%s to %s - %s at %s\n", f.getOriginName(), f.getDestinationName(), f.getDateof(), f.getTimeof());
            });
            
        
    }
}
