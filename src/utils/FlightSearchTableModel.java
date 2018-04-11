/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controllers.Flights;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author greta
 */
public class FlightSearchTableModel extends AbstractTableModel {
    private final String[] columnNames;
    private final Flights flights;
    SimpleDateFormat df;
    SimpleDateFormat tf;
    DecimalFormat cf; 
    
    public FlightSearchTableModel(Flights flights) {
        this.columnNames = new String[]{"Date", "Time", "Departing from", "Arriving at", "Price from"};
        this.flights = flights;
        this.df = new SimpleDateFormat("dd/MM/yyy");
        this.tf = new SimpleDateFormat("HH:mm:ss");
        this.cf = new DecimalFormat("###,###,### kr");
    }
    @Override
    public int getRowCount() {
        return flights.getFlights().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return df.format(flights.getFlights().get(rowIndex).getDate());
            case 1: return tf.format(flights.getFlights().get(rowIndex).getDate());
            case 2: return flights.getFlights().get(rowIndex).getOrigin();
            case 3: return flights.getFlights().get(rowIndex).getDestination();
            case 4: return cf.format(flights.getFlights().get(rowIndex).getPrice());
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    
}
