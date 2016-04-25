/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eztagserver;

import java.io.*;
import java.security.*;
import java.lang.Thread;
import java.net.Socket;
//import java.util.*;

/**
 *
 * @author jjred88
 */
public class Account implements Serializable {
    
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
    
    public Boolean verify(String uName, String pw){
        try {
            pw = encrypt(pw);
            if(!(this.getuName().equals(uName)) || !(this.getPass().equals(pw)))
                throw new Exception();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public static String search(String s){
        File folderToScan = new File("accounts/."); 
        File[] listOfFiles = folderToScan.listFiles();
        String target_file ;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                target_file = listOfFiles[i].getName();
                if (target_file.contains(s))
                    return target_file;
            }
        }
        
        return "";
    }
	
	public static Account open(int i){
		try {
            String fileName = search(Integer.toString(i));
            Account c;
            if(fileName.isEmpty())
                throw new Exception("No such account");
            
            FileInputStream streamIn = new FileInputStream("accounts/" + fileName);
            ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
            c = (Customer) objectinputstream.readObject();
            return c;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
    
    public static Account open(String s){
        try {
            String fileName = search(encrypt(s));
            Account c;
            if(fileName.isEmpty())
                throw new Exception("No such account");
            
            FileInputStream streamIn = new FileInputStream("accounts/" + fileName);
            ObjectInputStream objectinputstream = new ObjectInputStream(streamIn);
            if(fileName.endsWith(".ser"))
                c = (Employee) objectinputstream.readObject();
            else
                c = (Account) objectinputstream.readObject();
            return c;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Boolean exists(){
        String fileName = search(encrypt(uName));
        if(fileName.isEmpty())
            return false;
        return true;
    }
}
