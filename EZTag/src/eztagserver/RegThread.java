/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eztagserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author jjred88
 */
public class RegThread extends Thread{
    private final Socket sock;
    private final ObjectInputStream input;
    private final ObjectOutputStream output;
    
    public RegThread(Socket _socket, ObjectInputStream input, ObjectOutputStream output){
	sock = _socket;
        this.input = input;
        this.output = output;
    }
    
    public void run(){
        String msg;
        try{
            System.out.println("reg called");
            
            Customer c = (Customer)input.readObject();
			System.out.println(c.exists());
			if(c.exists()){
				output.writeObject(-1);
			}else{
				c.save();
				output.writeObject(1);
			}
            //System.out.println(msg);
        }catch(Exception e){
	    System.err.println("Error: " + e.getMessage());
	    e.printStackTrace(System.err);
        }
        
    }
}
