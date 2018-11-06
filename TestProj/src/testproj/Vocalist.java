/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproj;

/**
 *
 * @author Sunny
 */
public class Vocalist extends MaleKpopIdol {
    
    private boolean isVoiceHigh;
    
    /**
     * Creates new Vocalist object using parameters
     * to set name, initial age, weight and voice pitch
     * respectively to the data fields.
     * 
     * @param name name of the vocalist
     * @param age age of the vocalist
     * @param weight weight of the vocalist
     * @param isVoiceHigh voice pitch
     */
    public Vocalist (String name, int age, int weight, boolean isVoiceHigh){
        super(name, age, weight);
        this.isVoiceHigh = isVoiceHigh;
    }
    
    /**
     * prints some singing noises. if isVoiceHigh field has true prints
     * LA, otherwise LO.
     */
    @Override
    public void sing() {
        if (isVoiceHigh){
            System.out.println(getName() + " : \"LA LA LA\"");
        } else {
            System.out.println(getName() + " : \"LO LO LO\"");
        }
    }
    
    /**
     * prints the massage about idol practicing singing.
     */
    public void train(){
        System.out.println(getName() + " spends all his day practicing his new vocal part");
    }
    
    /**
      * String representation of idol object.
      * 
      * @return string with idol's name and vocalist position.
     */
    @Override
    public String toString(){
        return "Hello, my name is " + getName() + " and I has a vocalist position";
    }
    
}
