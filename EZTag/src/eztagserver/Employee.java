/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eztagserver;

/**
 *
 * @author jjred88
 */

import java.io.*;
import java.util.*;

public class Employee extends Account {
    
    private int SSN, empID;
    
    //Constructor

    public Employee(int SSN, String uName, String pass, String fName, String lName, String address) {
        super(uName, pass, fName, lName, address);
        this.SSN = SSN;
        Random ran = new Random();
        this.empID = (int)(Math.random() * 899999999) + 100000000;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }
    
    //Other functions
    public void save(){
        try {
            FileOutputStream fout = new FileOutputStream("accounts/" + encrypt(uName) + "." + empID);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
