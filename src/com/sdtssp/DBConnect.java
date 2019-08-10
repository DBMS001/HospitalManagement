/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdtssp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nilesh
 */
public class DBConnect 
{
    public static Connection con=null;
    static String user = System.getenv("USER");
    static String password = System.getenv("PASSWORD");
            
    
    public static Connection Connect() 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital",user, password);  
            return con;
        } catch (ClassNotFoundException|SQLException ex) 
        {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
}
