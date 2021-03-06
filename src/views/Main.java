/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.Bookings;
import datastructures.Flight;
import datastructures.User;
import java.awt.BorderLayout;
import database.DatabaseQueries;
/**
 *
 * @author greta
 */
public class Main extends javax.swing.JFrame {
    private final SearchView searchView;
    private FlightInfoView flightInfoView;
    private BookingsView bookingsView;
    private LoginView loginView;
    private final MyBookingsView myBookingsView;
    private Flight currentFlight;
    private User loggedInUser;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.searchView = new SearchView(this);
        this.myBookingsView = new MyBookingsView(this, null, "search");
        loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jLogin = new javax.swing.JMenu();
        jInnskraning = new javax.swing.JMenuItem();
        jRegister = new javax.swing.JMenuItem();
        jLogout = new javax.swing.JMenuItem();
        jMyBookings = new javax.swing.JMenuItem();
        jExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flight Search");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLogin.setText("Menu");

        jInnskraning.setText("Innskráning");
        jInnskraning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInnskraningActionPerformed(evt);
            }
        });
        jLogin.add(jInnskraning);

        jRegister.setText("Nýskráning");
        jRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterActionPerformed(evt);
            }
        });
        jLogin.add(jRegister);

        jLogout.setText("Útskráning");
        jLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutActionPerformed(evt);
            }
        });
        jLogin.add(jLogout);

        jMyBookings.setText("Mínar bókanir");
        jMyBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMyBookingsActionPerformed(evt);
            }
        });
        jLogin.add(jMyBookings);

        jExit.setText("Hætta");
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });
        jLogin.add(jExit);

        jMenuBar1.add(jLogin);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jExitActionPerformed

    private void jInnskraningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInnskraningActionPerformed
        loadLoginView("Innskráning");
    }//GEN-LAST:event_jInnskraningActionPerformed

    private void jRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterActionPerformed
        loadLoginView("Nýskráning");       
    }//GEN-LAST:event_jRegisterActionPerformed

    private void jLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutActionPerformed
        this.loggedInUser = null;
        this.myBookingsView.updateMyBookings(null);
    }//GEN-LAST:event_jLogoutActionPerformed

    private void jMyBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMyBookingsActionPerformed
        loadMyBookingsView();
    }//GEN-LAST:event_jMyBookingsActionPerformed
    
    /**
     * Loads a SearchView
     */
    public void loadSearchView() {
        if(this.flightInfoView != null) {
            this.remove(this.flightInfoView);
            this.flightInfoView = null;
        }
        if(this.loginView != null) {
            this.remove(this.loginView);
            this.loginView = null;
        } 
        if (this.myBookingsView != null){
            this.remove(this.myBookingsView);
        }
        this.add(searchView, BorderLayout.CENTER);
        this.pack();
        this.repaint();
    }
    
    /**
     * Loads a FlightView
     * @param flight 
     */
    public void loadFlightInfoView(Flight flight) {
        if (this.myBookingsView != null){
            this.remove(this.myBookingsView);
        } 
        if(this.loginView != null) {
            this.remove(this.loginView);
            this.loginView = null;
        } else if (this.bookingsView != null) {
            this.remove(this.bookingsView);
            this.bookingsView = null;
        } else {
            this.remove(searchView);
        }
        
        if(flight != null) {
            currentFlight = flight;
            this.flightInfoView = new FlightInfoView(this, flight);
        }
        this.add(this.flightInfoView, BorderLayout.CENTER);
        this.pack();
        this.repaint();
    }
    
    /**
     * Loads a BookingsView
     * @param flight 
     */
    public void loadBookingsView(Flight flight) {
        currentFlight = flight;
        if(this.flightInfoView != null) {
            this.remove(this.flightInfoView);
        }
        
        if(this.loginView != null) {
            this.remove(this.loginView);
            this.loginView = null;
        }
        if (this.myBookingsView != null){
            this.remove(this.myBookingsView);
        }
        this.bookingsView = new BookingsView(this, flight);
        this.add(this.bookingsView, BorderLayout.CENTER);
        this.pack();
        this.repaint();
    }
    
    /**
     * Loads a LoginView
     * @param buttonStatus
     */
     public void loadLoginView(String buttonStatus) {
         
         String prevOn = null;
        
         if (this.loginView != null) {
             String status = this.loginView.getButtonStatus();
             if(status.equals(buttonStatus)){
                 return;
             }else{
                 this.remove(this.loginView);
             }
        } if (this.myBookingsView != null){
            this.remove(this.myBookingsView);
            prevOn = "myBookings";
        } if (this.bookingsView != null) {
            this.remove(this.bookingsView);
            this.bookingsView = null;
            prevOn = "booking";
        } if (this.flightInfoView != null) {
            this.remove(this.flightInfoView);
            this.flightInfoView = null;
            prevOn = "info";
        } else{
            this.remove(searchView);
            this.currentFlight = null;
            prevOn = "search";
        } 
        
        this.loginView = new LoginView(this, currentFlight, prevOn, buttonStatus);
        this.add(this.loginView, BorderLayout.CENTER);
        this.pack();
        this.repaint();
     }
     
    
     public void setMyBookings(Bookings myBookings) {
         myBookingsView.updateMyBookings(myBookings);
     }
     
     /**
      * Loads a BookingsView
      */
     public void loadMyBookingsView() {
         String prevOn = null;

         if (this.bookingsView != null) {
            this.remove(this.bookingsView);
            prevOn = "booking";
         }
         if (this.flightInfoView != null) {
            this.remove(this.flightInfoView);
            this.flightInfoView = null;
            prevOn = "info";
         } else if (this.loginView != null) {
             this.remove(this.loginView);
             this.loginView = null;
             prevOn = "login";
         } else {
            this.remove(searchView);
            this.currentFlight = null;
            prevOn = "search";
        }
         
         this.myBookingsView.setPrevOn(prevOn);
         this.myBookingsView.setCurrentFlight(currentFlight);
         this.myBookingsView.setLoggedInUser(this.loggedInUser);
         this.myBookingsView.setHeader();
         
         this.add(this.myBookingsView, BorderLayout.CENTER);
         this.pack();
         this.repaint();
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main frame = new Main();
                frame.loadSearchView();
                frame.setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jExit;
    private javax.swing.JMenuItem jInnskraning;
    private javax.swing.JMenu jLogin;
    private javax.swing.JMenuItem jLogout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMyBookings;
    private javax.swing.JMenuItem jRegister;
    // End of variables declaration//GEN-END:variables
}
