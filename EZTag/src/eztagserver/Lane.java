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

import java.util.*;


public class Lane {   
    //Variables
    private double price;
    private String direction;
    
    //Constructor

    public Lane(int entrance, int exit) {
        setDirection(entrance, exit);
        setPrice();
    }
    
    //Setters and Getters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    
    //Override setters
    public void setPrice(){

        price = 0.4;
        if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) != 1 && Calendar.getInstance().get(Calendar.DAY_OF_WEEK) != 7){
            
        }
        if((direction.equals("east") && Calendar.HOUR_OF_DAY == 6) || (direction.equals("west") && (Calendar.HOUR_OF_DAY == 15 || Calendar.HOUR_OF_DAY == 18)))
            price = 2.10;
        
        if((direction.equals("east") && Calendar.HOUR_OF_DAY == 7) || (direction.equals("west") && (Calendar.HOUR_OF_DAY == 16 || Calendar.HOUR_OF_DAY == 17)))
            price = 3.20;
        
        if(direction.equals("east") && Calendar.HOUR_OF_DAY == 9)
            price = 1.50;
        
        if(direction.equals("east") && Calendar.HOUR_OF_DAY == 8)
            price = 2.60;
    }
    
    public void setDirection(int entrance, int exit){//entrance and exit numbering starts in the west
        if(entrance > exit)//Higher entrance means entered in the east and headed west
            direction = "west";
        else//Lower entrance means entered in the west and headed east
            direction = "east";
    }
}
