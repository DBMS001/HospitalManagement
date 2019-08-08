package com.sdtssp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sdtssp.hospitalUI.LoginPharmcy;
import com.sdtssp.hospitalUI.*;

/**
 *
 * @author shreeram
 */
public class Pharmacy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginPharmcy l = new LoginPharmcy();
                l.setVisible(true);
            }
        });
    }
    
}