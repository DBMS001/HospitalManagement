/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdtssp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nilesh
 */
public class DBConnect 
{
    public static Connection con=null;
    static String user = System.getenv("SQLUSERNAME");
    static String password = System.getenv("SQLPASSWORD");
            
    
    public static Connection Connect() 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(user+" "+password);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root", "root123");  
            return con;
        } catch (ClassNotFoundException|SQLException ex) 
        {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }     
    }
}
