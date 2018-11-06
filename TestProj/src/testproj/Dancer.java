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
public class Dancer extends MaleKpopIdol {
    
    private boolean isFit;
    
    /**
     * Creates new Dancer object using parameters
     * to set name, initial age, weight and isFit 
     * respectively to the data fields.
     * 
     * @param name name of the dancer
     * @param age age of the dancer
     * @param weight weight of the dancer
     * @param isFit strength of the dancer
     */
    public Dancer(String name, int age, int weight, boolean isFit) {
        super (name, age, weight);
        this.isFit = isFit;
    }
    
    /**
      * prints message of idol training dancing skills.
      */
    public void train(){
        isFit = true;
        System.out.println(getName() + " spends all his day practicing his new dance part");
    }
    
    /**
     * Depending on whether dancer is fit prints message 
     * of idol dancing. If Idol is fit he will add somersault, 
     * otherwise he will just dance.
     */
    @Override
    public void dance() {
        if(isFit) {
            System.out.println(getName() + " does a cool dance move and a somersault");
        } else {
            System.out.println(getName() + " does a cool dance move");
        }
    }
    
    /**
      * String representation of idol object.
      * 
      * @return string with idol's name and dancer position.
     */
    @Override
    public String toString(){
        return "Hello, my name is " + getName() + " and I has a dancer position";
    }
    
}
