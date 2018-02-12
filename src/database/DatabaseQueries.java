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
    
    private static int getAirportIdByName(String airportname) throws SQLException {
        int id = -1;
        String q = "SELECT id FROM airports WHERE lower(airportname) LIKE lower(?)";
        ConnectionPreparedStatement cpst = DatabaseConnection.getConnectionPreparedStatement(q);

        cpst.pst.setString(1, airportname);
        ResultSet rs =  cpst.pst.executeQuery();
        rs.next();
        id = rs.getInt(1);  

        cpst.close();

        return id;
    }
    
    /**
     * Finnur öll flug frá flugvelli origin til flugvallar destination.
     * @param origin nafn á flugvelli origin
     * @param destination nafn á flugvelli destination
     */
    public static void getAllFlightsToFrom(String origin, String destination) {
        try {
            int originId = getAirportIdByName(origin);
            int destinationId = getAirportIdByName(destination);
            
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
