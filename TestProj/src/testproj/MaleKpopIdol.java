/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproj;

/**
 * Idols are Korean pop stars that are usually able to 
 * do plenty of things beside singing.
 *
 * @author Sunny
 */
public class MaleKpopIdol {
    
    private String name;
    private int age;
    private int weight;
    private boolean visual = true;
    
    /**
     * Creates new MaleKpopIdol object using parameters
     * to set name, initial age and weight respectively
     * to the data fields.
     * 
     * @param name name of the idol
     * @param age age of the idol
     * @param weight weight of the idol
     */
    public MaleKpopIdol (String name, int age, int weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
        
        if (weight > 69 || weight < 55){
            visual = false;
        }
    }
    
    
    /**
     * returns the name of the idol.
     * 
     * @return the name of the idol
     */
    public String getName() {
        return name;
    }

    /**
     * returns the current age of the idol.
     * 
     * @return the age of the idol
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the current weight of the idol.
     * 
     * @return the weight of the idol
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * subtracts 3 from weight field. Changes the value
     * of visual field to true if it is between 55 and 69
     * inclusive.
     */
    public void goToDiet(){
        weight -= 1;  
        if (getWeight() <= 69 && getWeight() >= 55){
            visual = true;
        }
    }
    
    /**
     * Increases the weight field depending on the parameter
     * food choice. Food includes "chicken", "noodles", 
     * "fruits", "yogurt", "pizza", "burger", "cheese". 
     * Changes the value of visual field to false if it is 
     * more than 69.
     *  
     * @param food food to be eaten by an idol. 
     */
    public void midnightSnack(String food){
        if (food.equals("chicken") || food.equals("burger") 
                || food.equals("pizza")){
            weight += 3;
        }
        if (food.equals("noodles")){
            weight += 2;
        }
        if (food.equals("cheese") || food.equals("yogurt") 
                || food.equals("fruits")){
            weight += 1;
        }
        if (getWeight() < 69){
            visual = false;
        }
    }
    
    /**
     * prints the message about idol going to TV show. 
     */
    public void gainPopularity(){
        System.out.println(getName() + " goes to the Weekly Idol show");
    }
    
    /**
     * adds 1 to the age field.
     */
    public void happyBirthday(){
        age = age + 1;
        System.out.println("Congratulations! " + getName() + " is now " + getAge() +" years old");
    }
    
    /**
     * prints the message about idol going to photo session. If visual field is
     * true idol goes to ELLE magazine, otherwise idol has to train more.
     */
    public void goToFotoSession() {
        if (visual){
          System.out.println(getName() + " goes to foto session for ELLE magazine");
        } else {
          System.out.println(getName() + " has to train more or to go on a diet");
        }
    }
    
    /**
     * prints message about idol acting cute or if age field is more
     * than 22 he winks.
     */
    public void actCute(){
        if (getAge() < 22){
        System.out.println(getName() + " makes a cute face");
        } else {
        System.out.println(getName() + " smiles and winks");  
        }
    }
    
    /**
     * prints message about idol dancing. 
     */
    public void dance() {
        System.out.println(getName() + " does a simple dance move");
    }
    
    /**
     * prints message about idol singing.
     */
     public void sing() {
        System.out.println(getName() + " : \"la la la\"");
    }
    
     /**
      * String representation of idol object.
      * 
      * @return string with idol's name.
      */
    public String toString(){
         return "Hello, my name is " + getName() + ". Nice to meet You!";
    }
}
