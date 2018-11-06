/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalproj;

/**
 *
 * @author Sunny
 */
public interface Animal {
    
    /**
     * Returns the kind of the animal.
     * 
     * @return the kind of the animal
     */
    public String animalKind();
    
    /**
     * Return the current age of the animal.
     *  
     * @return the age of the animal
     */
    public int getAge();
    
    /**
     * Returns true iff the animal can eat the
     * given kind of food.
     * 
     * @param food the food that animal can eat
     * @return whether or not animal can eat the 
     * given kind of food
     */
    public boolean canEat(String food);
    
    /**
     * Increments the animal's age by one year.
     */
    public void ageOneYear() ;
    
    /**
     * Attempt to feed the animal the given food.
     * Throws the exception if the animal can't eat the food.
     * 
     * @param food the food that to be fed to the animal
     * @throws Exception if animal can't eat the food
     */
    public void feed(String food) throws Exception;
    
    /**
     * Returns true iff the animal can
     * drink given type of liquid.
     * 
     * @param liquid the liquid that animal can drink 
     * @return whether or not the animal can drink 
     * the given kind of liquid
     */
    public boolean canDrink(String liquid);
    
    /**
     * Attempt to give animal to drink the given liquid.
     * Throws the exception if the animal can't drink th liquid.
     * 
     * @param liquid the liquid that to be given to the animal
     * @throws Exception if animal can't drink the liquid
     */
      
    public void giveToDrink(String liquid) throws Exception;
    
    /**
     * Animal goes to sleep.
     */
    public void sleep();
    
    /**
     * Animal makes some characteristic noise.
     */
    public void makeNoise();
    
}
