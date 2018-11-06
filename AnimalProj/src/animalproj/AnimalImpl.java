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
public class AnimalImpl implements Animal{

     private int age;
     private int maxAge = 5;
     private boolean isAlive = true;
    
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void ageOneYear() {
        if (age > maxAge){
            isAlive = false;
            System.out.println("Oh no! " + animalKind() + " is dead");
        }
        age++;
    }
 
    @Override
    public void sleep() {
        System.out.println("Zzz...");
    }

    @Override
    public boolean canEat(String food) {
        return false;
    }

    @Override
    public void feed(String food) throws Exception {
        if (!this.canEat(food)){
            System.out.println("Please, specify your animal");
        }
    }

    @Override
    public String animalKind() {
        return "Specify your animal";
    }

    @Override
    public void giveToDrink(String liquid) throws Exception {
        if (!this.canDrink(liquid)){
            System.out.println("Animal can't drink" + liquid);
        }
        System.out.println("Gulp gulp");
    }

    @Override
    public void makeNoise() {
        System.out.println("Please, spesify your animal");
    }

    @Override
    public boolean canDrink(String liquid) {
        if(liquid.equals("Water")){
            return true;
        }
        return false;
    }

    public String toString(){
       return "An animal that is " + age + " years old";
    }
    
}
