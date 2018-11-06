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
public class Automobile {
    
    private boolean engineRunning;
    
    private double speed;
    
    private String carName;
    
    /**
     * Creates new Automobile object and sets speed field to zero,
     * engineRunning field to false, carName field to parameter 
     * argument, given that the argument has a value more than 0. 
     * If argument is out of range the exception is thrown and 
     * the carName field is set to 1.
     * 
     * @param licensePlate 
     * @throws Exception if license plate is negative or double
     */
    public Automobile(int licensePlate) throws Exception {
        engineRunning = false;
        speed = 0.0;
        
        if (licensePlate <= 0) {
            throw new Exception ("Invalid license plate value");
        }
        carName = "car#" + licensePlate;
     }
    
    /**
     * Sets the engineRunning field to true.
     */
    public void startCar(){
        engineRunning = true;
    }
    
    /**
     * If engineRunning is true then adds 10 to the speed 
     * field.
     * @throws Exception if engine is turned off.
     */
    public void pressGasPedal() throws Exception{
        if (engineRunning){
        speed = speed +10.0;
    } else {
            throw new Exception ("You should run your engine first!");
        }
    }
    
    /**
     * Sets speed field to 0.
     */
    public void pressBrake(){
        speed = 0.0;
    }
    
    /**
     * Sets engineRunning field to false.
     */
    public void shutdown(){
        engineRunning = false;
    }
    
    /**
     * Returns current engine condition.
     * 
     * @return engineRunning 
     */
    public boolean isEngineRunning(){
        return engineRunning;
    }
    
    /**
     * Returns current speed value.
     * 
     * @return speed
     */
    public double getSpeed(){
        return speed;
    }
    
    /**
     * Returns car name.
     * 
     * @return carName
     */
    public String getCarName(){
        return carName;
    }
    
    /**
     * Calculates the traveled distance using parameter 
     * argument and multiplying it by current speed field 
     * value, given that argument has a value more than 0.
     * 
     * @param time time past
     * @return distance car goes with current speed for 
     * time parameter
     * @throws Exception if time is negative
     */
    public double calculateDistance(double time) throws Exception {
        if (time < 0){
            throw new Exception("Time must be positive! Learn some physics, man!");
        }
        
        return time * speed;
    }
    
    /**
     * Returns the string with current car state
     * 
     * @return car state
     */
    @Override
    public String toString() {
        return carName + " state: Engine running: " + engineRunning +
                " Speed: " + speed;
    }
}
