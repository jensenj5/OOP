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
            String user, pw, msg;
            do{
                user = (String)input.readObject();
                pw = (String)input.readObject();
                Account a = Account.open(user);
                if(a instanceof Employee){
                    Employee e = (Employee) a;
                    //output.writeObject("Employee");
                    if(e == null)
                        output.writeObject("Invalid");
                    else if(e.verify(user, pw)){
                        output.writeObject("Employee");
                        //output.writeObject(e);
                        //while(true){
                        //    e = (employee)
                        //}
                    }
                    while(true){//Open multiple accounts while logged in
                        msg = (String)input.readObject();//Receives username/acc #
                        Customer c = (Customer)Account.open(msg);//If username
                        System.out.println("1");
                        if(c != null){
                            output.writeObject(true);
                            output.writeObject(c);
                            boolean j = true;
                            while(j){//Can make multiple changes to account
                                c = (Customer)input.readObject();// (Strig)input.readObject();
                                if (c == null)
                                    j = false;
                                else
                                    c.save();
                            }
                        }else
                            output.writeObject(false);
                    }
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
