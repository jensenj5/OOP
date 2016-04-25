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

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class EZTag {

    /**
     * @param args the command line arguments
     */
    
    public static final int SERVER_PORT = 8765;
    
    public static void main(String[] args) {
        // TODO code application logic here
        //Employee a = new Employee(123456789, "admin", "admin", "Jason", "Jensen", "1 Main");
        //a.save();
        try{
	    // This is basically just listens for new client connections
            final ServerSocket serverSock = new ServerSocket(SERVER_PORT);
            ObjectOutputStream output = null;
            ObjectInputStream input = null;
	    String msg;
	    // A simple infinite loop to accept connections
	    Socket sock = null;
	    Thread thread = null;
	    while(true){
		sock = serverSock.accept();     // Accept an incoming connection
                output = new ObjectOutputStream(sock.getOutputStream());
                output.flush();
                input = new ObjectInputStream(sock.getInputStream());
                
               /* System.out.println("Connected LOGIN");
		thread = new EZThread(sock);  // Create a thread to handle this connection
		thread.start();       */          // Fork the thread
                //System.out.println("connceted");
                //System.out.println(sock.getPort());
                msg = (String)input.readObject();
                if(msg.equals("Login")){
                    thread = new LoginThread(sock, input, output);
                }
                if(msg.equals("Register")){
                    thread = new RegThread(sock, input, output);
                }
                if(msg.equals("Event")){
                    thread = new EventThread(sock, input, output);
                }
                thread.start();                
	    }                                   // Loop to work on new connections while this
                                                // the accept()ed connection is handled

	}catch(Exception e){
	    System.err.println("Error: " + e.getMessage());
	    e.printStackTrace(System.err);
	}
    }
    
}
