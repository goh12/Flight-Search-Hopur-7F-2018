/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

        
/**
 *
 * @author greta
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseConnection {
    private static final String URL = 
            "jdbc:postgresql://localhost/fauxflightdb?user=fsdev&password=fsdev123";
    public DatabaseConnection() throws SQLException {
    Connection conn = null;
    
    try {
        /*
            Prufa! Bara til að hafa smá reference.
        */
        conn = DriverManager.getConnection(URL);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM flights");
        String str = null;
        while (rs.next())
        {
            str = String.format("%s, %s, %s, %s, %s", rs.getString(1), 
                    rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getInt(5));
            System.out.println(str);
        }
        rs.close();
        st.close();
    } catch (SQLException e) {
        System.out.println(e.toString());
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
        
        
    }
    
}
