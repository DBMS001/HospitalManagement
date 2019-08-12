/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sdtssp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nilesh
 */
public class Validators {
    final String emailReg = "^[A-Za-z0-9+_.-]+@(.+)$";
    final String contactReg = "^[0-9]{10}$";
    Pattern patemail,patcontact;
    
    public Validators(){
        patemail = Pattern.compile(emailReg);
        patcontact = Pattern.compile(contactReg);
    }
        
    
    public boolean valEmail(String email){
         return patemail.matcher(email).matches();
    }
    
    public boolean valPhn(String contact){
         return patcontact.matcher(contact).matches();
    }
}
