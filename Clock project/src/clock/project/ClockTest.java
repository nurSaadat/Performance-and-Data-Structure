/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock.project;

/**
 *
 * @author Sunny
 */
public class ClockTest {
    
    public static void main (String[] args){
        
        
        try {
            Clock wristWatch = new Clock(12,20,5);
            
            System.out.println(wristWatch.isMorning());
            
            wristWatch.resetToMidnight();
        
            System.out.println(wristWatch);
        
            wristWatch.setClock(14,2 , 56);
        
            System.out.println(wristWatch);
                  
            wristWatch.tick();
            wristWatch.tick();
            wristWatch.tick();
            wristWatch.tick();

            System.out.println(wristWatch);

            wristWatch.getHours();
            wristWatch.getMinutes();
            wristWatch.getSeconds();

            wristWatch.setClock(4, 9, 4);

            System.out.println(wristWatch);
            
             wristWatch.setClock(-48, 9, 4);

            System.out.println(wristWatch);

            wristWatch.setHours(0);
            wristWatch.setMinutes(898);
            wristWatch.setSeconds(17);

            System.out.println(wristWatch);
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
            
        }
  
              
    }
}
