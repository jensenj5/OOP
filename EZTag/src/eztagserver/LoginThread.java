/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eztagserver;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 *
 * @author jjred88
 */
public class LoginThread extends Thread{
    private final Socket sock; 
    private final ObjectInputStream input;
    private final ObjectOutputStream output;
    //ObjectInputStream input = null;
    //ObjectOutputStream output = null;
    
    public LoginThread(Socket _socket, ObjectInputStream input, ObjectOutputStream output){
	sock = _socket;
        this.input = input;
        this.output = output;
    }
    
    public void run(){        
        try{
			String user, pw;
			do{
            System.out.println("test");
            //final ObjectOutputStream output = new ObjectOutputStream(sock.getOutputStream());
            System.out.println("test");
            //final ObjectInputStream input = new ObjectInputStream(sock.getInputStream());
            
            //while(true){
            System.out.println("Login");
            user = (String)input.readObject();
            System.out.println(user);
            pw = (String)input.readObject();
            System.out.println(pw);
            //System.out.println(msg);
            //Customer c = Customer.open(Integer.parseInt(txtAccountNumber.getText()));
            System.out.println("Attempting to open account");
            Account a = Account.open(user);
            if(a instanceof Employee){
                output.writeObject("Employee");
                //Employee e = (Employee) a;
                //New UI here to request acc #
                //Customer c = Account.open(accnum);
                System.out.println("Employee acc");
            }else {
                Customer c = (Customer) a;
				if(c == null)
					output.writeObject("Invalid");
				else if(c.verify(user, pw)){
                    output.writeObject("Customer");
                    output.writeObject(c);
					while(true){
						c = (Customer)input.readObject();// (Strig)input.readObject();
						c.save();
					}
                
                }else{
                    output.writeObject("Invalid");
                }
            }
			}while(user != null);
        }catch(Exception e){
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace(System.err);
		}
    }
}
