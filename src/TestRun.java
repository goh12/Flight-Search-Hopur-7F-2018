
import database.DatabaseConnection;
import java.sql.SQLException;

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
    public static void main(String[] args) {
        try {
            DatabaseConnection c = new DatabaseConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
}
