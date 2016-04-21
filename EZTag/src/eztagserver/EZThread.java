/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eztagserver;
import java.io.*;
import java.net.*;

/**
 *
 * @author jjred88
 */

import java.net.*;

public class EZThread extends Thread {
    private final Socket sock;  
    
    public EZThread(Socket _socket){
	sock = _socket;
    }
    
    public void run(){
        String msg;
        try{
            final ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
            final ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
            msg = (String)input.readObject();
            System.out.println(msg);
        }catch(Exception e){
	    System.err.println("Error: " + e.getMessage());
	    e.printStackTrace(System.err);
        }
        
    }
}
