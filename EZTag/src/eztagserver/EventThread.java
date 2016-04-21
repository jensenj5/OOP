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
public class EventThread extends Thread{
    private final Socket sock;  
    private final ObjectInputStream input;
    private final ObjectOutputStream output;
    
    public EventThread(Socket _socket, ObjectInputStream input, ObjectOutputStream output){
	sock = _socket;
        this.input = input;
        this.output = output;
    }
    
    public void run(){
        String msg;
		int rfid, ent, exit;
        try{
            //final ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
            //final ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
            msg = (String)input.readObject();
            System.out.println(msg);
			rfid = (int)input.readObject();
			ent = (int)input.readObject();
			exit = (int)input.readObject();
			new VirtualScanner(rfid, ent, exit);
        }catch(Exception e){
	    System.err.println("Error: " + e.getMessage());
	    e.printStackTrace(System.err);
        }
        
    }
}
