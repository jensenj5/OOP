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
public class VirtualScanner {
    private static int rfid, entrance, exit;

    public static int getRfid() {
        return rfid;
    }

    public static void setRfid(int rfid) {
        VirtualScanner.rfid = rfid;
    }

    public static int getEntrance() {
        return entrance;
    }

    public static void setEntrance(int entrance) {
        VirtualScanner.entrance = entrance;
    }

    public static int getExit() {
        return exit;
    }

    public static void setExit(int exit) {
        VirtualScanner.exit = exit;
    }
}
