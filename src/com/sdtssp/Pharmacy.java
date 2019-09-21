package com.sdtssp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sdtssp.hospitalUI.LoginPharmcy;
import com.sdtssp.hospitalUI.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author shreeram
 */
public class Pharmacy {

    /**
     * @param args the command line arguments
     */
    static Statement stmt;
    private static Connection conn = DBConnect.Connect();
    static ResultSet rs;
    static int i;
public static int updateMedQty(int qty, String name){ 
    int status = 0;    
        try {
            System.out.println("qty:"+qty);
            stmt = conn.createStatement();
            String sql = "update medicine set Qty = "+qty +" where Name = '"+ name +"';";
            System.out.println("sql:"+sql);
            status = stmt.executeUpdate(sql);    
            System.out.println("status :"+status);
        } catch (SQLException ex) {
            Logger.getLogger(Pharmacy.class.getName()).log(Level.SEVERE, null, ex);
        }
    return status;
}
    public static ResultSet selectMedItems(String med) {
         try {
            
            stmt = conn.createStatement();
            String sql = "select * from medicine where Name "+med;
               System.out.println("sql:"+sql);
            rs = stmt.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(Retail.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }
    public static int myau(String m){
        System.out.println("com.sdtssp.Pharmacy.myau() : "+m);
        return i;
    }
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginPharmcy l = new LoginPharmcy();
                l.setVisible(true);
            }
        });
    }
    
}