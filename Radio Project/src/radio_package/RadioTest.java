/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio_package;

/**
 *
 * @author Sunny
 */
public class RadioTest {
    
    public static void main (String [] args){
        
        Radio myRadio = new Radio();
        
        System.out.println(myRadio);
        
        myRadio.setOn(true);
        myRadio.setStation(171.9);
        myRadio.setVolume(12);
        
        System.out.println(myRadio);
    }
    
}
