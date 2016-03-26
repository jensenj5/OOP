/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eztag;

import java.io.*;
//import java.util.*;

/**
 *
 * @author jjred88
 */
public class Account implements Serializable{
    
    //Variables        
    protected String uName, pass, fName, lName, address;
    
    //Constructor
    public Account(String uName, String pass, String fName, String lName, String address) {
        this.uName = uName;
        this.pass = pass;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
    }
    
    //Setters and Getters
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //Other Functions
    
}
