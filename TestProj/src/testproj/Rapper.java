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
public class Rapper extends MaleKpopIdol {
    
    /**
     * Creates new Rapper object using parameters
     * to set name, initial age and weight respectively
     * to the data fields.
     * 
     * @param name name of the rapper
     * @param age age of the rapper
     * @param weight weight of the rapper
     */
     public Rapper (String name, int age, int weight){
         super (name, age, weight);
     }
    
     /**
      * prints message that idol can not sing.
      */
     @Override
     public void sing(){
         System.out.println(getName() + " can't sing, but he can read a rap part");
     }
     /**
      * prints message of idol rapping.
      */
     public void rap() {
         System.out.println(getName() + " takes a deep breath and reads his rap part");
     }
     
     /**
      * prints message of idol training rapping skills.
      */
     public void train() {
         System.out.println(getName() + " spends all his day practicing his new rap part");
     }
     
     /**
      * String representation of idol object.
      * 
      * @return string with idol's name and rapper position.
     */
     @Override
     public String toString(){
        return "Hello, my name is " + getName() + " and I has a rapper position";
    }
}
