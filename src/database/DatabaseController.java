/*
    Klasi sem heldur utan um 2 undirklasa, ConnectionStatement og 
    ConnectionPreparedStatemnt.

    Klassinn inniheldur einnig 2 static aðferðir sem búa skila einfaldlega 
    hlutum af gerð ConnectionStatement og ConnectionPreparedStatement.
*/
package database;

        
/**
 *
 * @author greta
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseController {
    private static final String URL = 
            "jdbc:postgresql://localhost/fauxflightdb?user=fsdev&password=fsdev123";
    private DatabaseController() {}
    
    /* Prufufall, "SÝNIFALL"
    public void prufa(){
        try {
            ConnectionStatement cst = getConnectionStatement();
            ResultSet rs = cst.st.executeQuery("SELECT a1.airportname, a2.airportname, f.timeof "
                    + "FROM flights f JOIN airports a1 ON a1.id = f.origin "
                    + "JOIN airports a2 ON a2.id = f.destination;");
            
            while (rs.next()) {
                System.out.printf("%s til %s, kl %s\n", rs.getString(1),
                        rs.getString(2), rs.getString(3));
            }
            
            cst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
    /**
     * Býr til nýtt ConnectionStatement
     * @return new ConnectionStatement
     * @throws SQLException 
     */
    public static ConnectionStatement getConnectionStatement() 
            throws SQLException {
        return new ConnectionStatement();
    }
    
    /**
     * Býr til nýtt ConnectionPreparedStatement
     * @param st fyrir PreparedStatement
     * @return new ConnectionPreparedStatement
     * @throws SQLException 
     */
    public static ConnectionPreparedStatement getConnectionPreparedStatement(String st) 
            throws SQLException {
        return new ConnectionPreparedStatement(st);
    }
    
    
    
    
    
    /*
        Klasi heldur utan um Connection og Statement hluti sem notaðir
        eru í queries. 
        
        Búa á til nýjan hlut af þessum klasa ef þarf að hafa samband við
        gagnagrunn með queries sem hafa engin parameters.
    
        Það þarf alltaf að kalla á close() á hlut þegar búið er að
        nota hann. (Hægt að skoða prufufall fyrir ofan)
    */
    public static class ConnectionStatement {
        final Connection conn;
        final Statement st;
        
        ConnectionStatement() throws SQLException {
            conn = DriverManager.getConnection(URL);
            st = conn.createStatement();
        }
        
        void close() throws SQLException {
            st.close();
            conn.close();
        }
    }
    
    /*
        Klasi heldur utan um Connection og Statement hluti sem notaðir
        eru í queries. 
        
        Búa á til nýjan hlut af þessum klasa ef þarf að hafa samband við
        gagnagrunn með queries sem hafa parameters.
    
        Það þarf alltaf að kalla á close() á hlut þegar búið er að
        nota hann. (Hægt getFlightsToFrom í DatabaseQueries fyrir dæmi)
    */
    public static class ConnectionPreparedStatement {
        final Connection conn;
        final PreparedStatement pst;
        
        ConnectionPreparedStatement(String st) throws SQLException {
            conn = DriverManager.getConnection(URL);
            pst = conn.prepareStatement(st);
        }
        
        void close() throws SQLException {
            pst.close();
            conn.close();
        }
    }
}
