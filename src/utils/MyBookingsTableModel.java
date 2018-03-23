/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import datastructures.Booking;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gudmu
 */
public class MyBookingsTableModel extends AbstractTableModel {
    private final String[] columnNames;
    private final ArrayList<Booking> bookings;
    
    public MyBookingsTableModel(ArrayList<Booking> bookings) {
        this.columnNames = new String[]{"Bókunarnúmer", "Kennitala", "Flugnúmer", "Sæti"};
        this.bookings = bookings;
}
    @Override
    public int getRowCount() {
        return bookings.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return bookings.get(rowIndex).getId();
            case 1: return bookings.get(rowIndex).getSsn();
            case 2: return bookings.get(rowIndex).getFlightId();
            case 3: return bookings.get(rowIndex).getSeatId();
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
