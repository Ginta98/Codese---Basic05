/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiennd
 */
public class DaLuong implements Runnable {
    
    int id;
    
    @Override
    public void run() {
        while (true) {
            System.out.println("Luong " + id);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(DaLuong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
