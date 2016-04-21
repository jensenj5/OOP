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

public class Customer extends Account {
    
    //Variables
    private int accNum;
    private double balance;
    private String make, model, plate, ccNum;
    
    
    //Constructor
    public Customer(double balance, String make, String model, String plate, String ccNum, String uName, String pass, String fName, String lName, String address) {
        super(uName, pass, fName, lName, address);
        Random ran = new Random();
        this.accNum = (int)(Math.random() * 899999999) + 100000000;
        this.balance = balance;
        this.make = make;
        this.model = model;
        this.plate = plate;
        this.ccNum = ccNum;
    }
    
    //Setters and Getters
    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }
    
    //Other functions
    public void save(){
        try {
            FileOutputStream fout = new FileOutputStream("accounts/" + encrypt(uName) + "." + accNum);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            oos.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.exit(0);
        }
    }
	public Boolean exists(){
		String fileName = search(encrypt(uName));
        if(fileName.isEmpty())
            //throw new Exception("Username already in use!");
			return false;
		return true;
	}
    
    public void generateCharge(int len, double price){
        balance -= (len * price);
    }
}

