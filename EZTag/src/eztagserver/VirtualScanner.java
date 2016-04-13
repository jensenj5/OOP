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
public class VirtualScanner {
    private int rfid, entrance, exit;
    
    //Constructor
    public VirtualScanner(int rfid, int entrance, int exit) {
        this.rfid = rfid;
        this.entrance = entrance;
        this.exit = exit;/*
        try{
            Customer c = Customer.open(rfid);
            c.generateCharge(Length(), new Lane(entrance, exit).getPrice());
            c.save();
        }catch(Exception e){
            e.printStackTrace();
            //This will pass license plate info from camera to DMV to be manually billed
        }*/
        
    }
    
    //Setters and Getters
    public int getRfid() {
        return rfid;
    }

    public void setRfid(int rfid) {
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
