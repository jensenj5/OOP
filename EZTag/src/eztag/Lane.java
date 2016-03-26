/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eztag;

/**
 *
 * @author jjred88
 */

import java.io.*;
import java.util.*;
import java.time.*;


public class Lane {
    public void addLane(){
        
    }
    
    public double setPrice(int direction){

        double price = 0.4;
        
        if(Calendar.getInstance().get(Calendar.DAY_OF_WEEK) != 1 && Calendar.getInstance().get(Calendar.DAY_OF_WEEK) != 7){
            
        }
        if((direction == 1 && Calendar.HOUR_OF_DAY == 6) || (direction == -1 && (Calendar.HOUR_OF_DAY == 15 || Calendar.HOUR_OF_DAY == 18)))
            price = 2.10;
        
        if((direction == 1 && Calendar.HOUR_OF_DAY == 7) || (direction == -1 && (Calendar.HOUR_OF_DAY == 16 || Calendar.HOUR_OF_DAY == 17)))
            price = 3.20;
        
        if(direction == 1 && Calendar.HOUR_OF_DAY == 9)
            price = 1.50;
        
        if(direction == 1 && Calendar.HOUR_OF_DAY == 8)
            price = 2.60;

        return price;
    }
}
