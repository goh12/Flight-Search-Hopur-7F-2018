/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.components;

import datastructures.Seat;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author greta
 */
public class SeatButton extends JButton {
    private boolean isBooked;
    private boolean isSelected = false;
    private Seat seat;
    
    public SeatButton(Seat seat) {
        super();
        
        Dimension preferredSize = new Dimension(30, 30);
        this.setPreferredSize(preferredSize);
        
        this.isBooked = seat.isBooked();
        this.seat = seat;
        if (seat.isBooked()) setBooked();
        else setAvailable();
        
        this.setText(seat.getSeatId());
        this.setBorder(null);
        this.setFocusable(false);
    }
    
    /**
     * Sets this seat as booked
     */
    public void setBooked() {
        this.setBackground(new Color(255, 0, 0));
        
    }
    
    /**
     * Sets this seat as available
     */
    public void setAvailable() {
        this.setBackground(new Color(0, 255, 50));
    }
    
    /**
     * Sets this seat as selected.
     */
    public void setSelected() {
        if (isBooked) return;
        
        isSelected = !isSelected;
        if(isSelected) this.setBackground(new Color(125, 125, 0));
        else setAvailable();
    }
    
    public boolean isBooked() {
        return isBooked;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public Seat getSeat() {
        return seat;
    }
    
    
}
