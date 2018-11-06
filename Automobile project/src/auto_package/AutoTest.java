/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto_package;

/**
 *
 * @author Sunny
 */
public class AutoTest {
    
    public static void main (String[] args){
       
        try {
            Automobile car = new Automobile(1);
            Automobile car1 = new Automobile(2);
            
            car.startCar();
            car.pressGasPedal();
            car.pressGasPedal();
            
            car1.startCar();
            car1.pressGasPedal();
            
            System.out.println("Current speed of " + car.getCarName() + " is " + car.getSpeed());
            System.out.println("Current speed of " + car1.getCarName() + " is " + car1.getSpeed());
            
            car.pressBrake();
            car1.pressGasPedal();
            
            System.out.println(car);
            System.out.println(car1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
