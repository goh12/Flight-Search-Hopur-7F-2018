/*
    Klasi sem býr til föll til að halda utan um allar GENERIC queries.
    Búa til public föll fyrir eitthvað query og private föll til
    hjálpar ef þarf.
*/
package database;

import database.DatabaseConnection.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author greta
 */
public class DatabaseQueries {
    private DatabaseQueries() {}
    
    /**
     * Finnur öll flug frá flugvelli origin til flugvallar destination.
     * @param origin nafn á flugvelli origin
     * @param destination nafn á flugvelli destination
     */
    public static void getAllFlightsToFrom(String origin, String destination) {
        try {
            String q = "SELECT id FROM airports WHERE lower(airportname) LIKE lower(?)";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setString(1, origin);
            ResultSet rs =  cpst.pst.executeQuery();
            rs.next();
            int originId = rs.getInt(1);
            
            cpst.pst.setString(1, destination);
            rs = cpst.pst.executeQuery();
            rs.next();
            int destinationId = rs.getInt(1);
            cpst.close();
            
            getAllFlightsToFrom(originId, destinationId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Private finnur öll flug frá origin til destination með ID flugvalla
     * @param originId
     * @param destinationId 
     */
    private static void getAllFlightsToFrom(int originId, int destinationId) {
        try {
            String q = "SELECT dateof, timeof FROM flights WHERE origin = ? AND destination = ?";
            ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);
            
            cpst.pst.setInt(1, originId);
            cpst.pst.setInt(2, destinationId);
            ResultSet rs =  cpst.pst.executeQuery();
            
            while (rs.next()) {
                System.out.printf("%s, %s\n", rs.getString(1), rs.getString(2));
            }
            cpst.close();       
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
