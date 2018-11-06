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
public class Clock {
  
    // Fields
    private int hours;
    private int minutes;
    private int seconds;
 
    // Constructor
    
    /**
     * Creates new clock item with default field values
     */
    public Clock(){
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    
   /**
    * Creates new clock item and sets the hours, minutes, seconds to parameter
    * arguments, given that the arguments have valid values.
    * (between 0 and 59, between 0 and 59 and between 0 and 23 respectively.)
    * If arguments are out of range, fields are set to 0 and 
    * exception is thrown.
    * 
    * @param hours the hours to set
    * @param minutes the minutes to set 
    * @param seconds the seconds to set
    * 
    * @throws Exception if any parameter is out of range
    */
    public Clock(int hours, int minutes, int seconds) throws Exception {
        
        if (hours < 0 || hours > 59){
            this.hours = 0;
            throw new Exception ("hours is out of range");
        }
        this.hours = hours; 
       
        if (minutes < 0 || minutes > 59) {
            this.minutes = 0;
            throw new Exception ("minutes is out of range");
        }    
        this.minutes = minutes;
       
        if (seconds < 0 || seconds > 59){
            this.seconds = 0;
            throw new Exception ("seconds is out of range");
        }
        this.seconds = seconds;
    }
 
     
    // Reset method
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }
 
    // Check if morning 
    public boolean isMorning() {
        return getHours() < 12;
    }
 
  
    // Advance one second method
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes >=60) {
            minutes = 0;
            hours++;
        }
        if (hours >= 24) {
            hours = 0;
        }
    }
    
    /**
     * Sets the Clock fields to parameter values respectively.
     * 
     * @param hours hours to be set
     * @param minutes minutes to be set
     * @param seconds seconds to be set
     * 
     * @throws Exception if any parameter is out of range
     */
    public void setClock(int hours, int minutes, int seconds) throws Exception{
        if (hours < 0 || hours > 59){
            this.hours = 0;
            throw new Exception ("hours is out of range");
        }
        this.hours = hours; 
       
        if (minutes < 0 || minutes > 59) {
            this.minutes = 0;
            throw new Exception ("minutes is out of range");
        }    
        this.minutes = minutes;
       
        if (seconds < 0 || seconds > 59){
            this.seconds = 0;
            throw new Exception ("seconds is out of range");
        }
        this.seconds = seconds;
    }
    
    /**
     * Returns the string with current time value
     * 
     * @return the clock object
     */
    @Override
    public String toString(){
        String hoursDisplay;
        String minutesDisplay;
        String secondsDisplay;
        
        if (getHours() < 10){
            hoursDisplay = "0" + getHours();
        } else {
            hoursDisplay = "" + getHours();
        }
        
        if (getMinutes() < 10){
            minutesDisplay = "0" + getMinutes();
        } else {
            minutesDisplay = "" + getMinutes();
        }
        
        if (getSeconds() < 10){
            secondsDisplay = "0" + getSeconds();
        } else {
            secondsDisplay = "" + getSeconds();
        }
        
        return "Time is " + hoursDisplay + ":" + minutesDisplay + ":" + secondsDisplay;
    }
    
    /**
     * Returns the current value of hours
     * 
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * Changes the hours field to the parameter
     * argument, given that the argument has a value 
     * between 0 and 23 inclusive. If the hours
     * argument is not in the valid range, the hours 
     * field remains unchanged and exception is thrown.
     * 
     * @param hours the hours to set
     * @throws Exception if hours are not in range
     */
    public void setHours(int hours) throws Exception {
        if (hours < 0 || hours > 23) {
            throw new Exception ("hours is out of range.");
        }
        this.hours = hours;
    }

    /**
     * Returns the current value of minutes
     * 
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Changes the minutes field to the parameter
     * argument, given that the argument has a value 
     * between 0 and 59 inclusive. If the minutes 
     * argument is not in the valid range, the minutes
     * field remains unchanged and exception is thrown.
     * 
     * @param minutes the minutes to set
     * @throws Exception if minutes is out of range
     */
    public void setMinutes(int minutes) throws Exception {
        if (minutes < 0 || minutes > 59) {
            throw new Exception ("minutes is out of range.");
        }
        this.minutes = minutes;
    }

    /**
     * Returns the current value of seconds
     * 
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Changes the seconds field to the parameter 
     * argument, given that the argument has a value 
     * between 0 and 59 inclusive. If the seconds 
     * argument is not in the valid range, the seconds
     * field remains unchanged, and exception is
     * thrown.
     *      * 
     * @param seconds the seconds to set
     * @throws Exception if seconds are not in range.
     */
    public void setSeconds(int seconds) throws Exception {
        if (seconds < 0 || seconds > 59){
            throw new Exception("seconds is not in range.");
        }
        this.seconds = seconds;
    }
}

