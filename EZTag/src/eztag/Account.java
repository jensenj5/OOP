/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eztag;

import java.io.*;
import java.security.*;
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
        this.pass = encrypt(pass);
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
    public static String encrypt(String pass){//Encrypts password using MD5
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
   }
    
    //public static int search(String user){
        //try
    //}
}
