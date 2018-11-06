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
public class Radio {
    
    private int volume;
    
    private double station;
    
    private boolean on;
    
    /**
     * Creates new radio item.
     */
    public Radio(){
        volume = 0;
        station = 0.0;
        on = false;
    }

    /**
     * Returns the volume.
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets the volume field to the given parameter.
     * @param volume the volume to set
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Returns the station.
     * @return the station
     */
    public double getStation() {
        return station;
    }

    /**
     * Sets the station field to the given parameter.
     * @param station the station to set
     */
    public void setStation(double station) {
        this.station = station;
    }

    /**
     * Checks is the radio is turned on.
     * @return the on
     */
    public boolean isOn() {
        return on;
    }

    /**
     * Sets the on field to the given parameter.
     * @param on the on to set
     */
    public void setOn(boolean on) {
        this.on = on;
    }
    
    public String toString(){
        return "Radio is on: " + isOn() + " Station: " + getStation() + " Volume: " + getVolume();
    }
    
}
