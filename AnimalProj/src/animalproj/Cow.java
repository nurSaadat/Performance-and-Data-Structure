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
public class Cow extends AnimalImpl{
   
    @Override
    public String animalKind() {
        return "Cow";
    }

    

    @Override
    public boolean canEat(String food) {
        if(food.equals("Grass")){
            return true;
        }
        return false;
    }
   
    @Override
    public void feed(String food) throws Exception {
        if (!this.canEat(food)){
            throw new Exception ("Cow can not eat " + food);
        }
        System.out.println("Chew, chew, chew...");
    }

    
    @Override
    public void makeNoise() {
        System.out.println("Moooo");
    }
}
