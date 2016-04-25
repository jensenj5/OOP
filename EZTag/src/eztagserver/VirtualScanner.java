/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eztagserver;
import java.lang.Thread;
import java.net.Socket;

/**
 *
 * @author jjred88
 */
public class VirtualScanner extends Thread{
    private String rfid;
    private int entrance, exit;
    
    //Constructor
    public VirtualScanner(String rfid, int entrance, int exit) {
        this.rfid = rfid;
        this.entrance = entrance;
        this.exit = exit;
        try{
            Account a = Account.open(rfid);
			Customer c = (Customer)a;
            c.generateCharge(Length(), new Lane(entrance, exit).getPrice());
            c.save();
        }catch(Exception e){
            e.printStackTrace();
            //This will pass license plate info from camera to DMV to be manually billed
        }
        
    }
    
    //Setters and Getters
    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }

    public int getExit() {
        return exit;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }
    
    //Override setter
    public int Length(){
        return Math.abs(entrance - exit);
    }
}
