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
public class Panda extends AnimalImpl{
    
    
   
    @Override
    public String animalKind() {
        return "Panda";
    }

    

    @Override
    public boolean canEat(String food) {
        if(food.equals("Bamboo")){
            return true;
        }
        return false;
    }
   
    @Override
    public void feed(String food) throws Exception {
        if (!this.canEat(food)){
            throw new Exception ("Panda can not eat " + food);
        }
        System.out.println("Crunch crunch");
    }

    
    @Override
    public void makeNoise() {
        System.out.println("Squeeeeek");
    }
    
    
}


