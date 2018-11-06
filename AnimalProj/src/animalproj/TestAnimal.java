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
public class TestAnimal {
    
    public static void feedMeat(Animal animal){
        
        try{
        animal.feed("Meat");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void giveCola(Animal animal){
        
        try{
        animal.giveToDrink("Cola");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args){
    
    Animal cow = new Cow();
    Animal tiger = new Tiger();
    Animal panda = new Panda();
    
    feedMeat(cow);
    feedMeat(tiger);
    feedMeat(panda);
    
    cow.canDrink("Water");
    giveCola(tiger);
    
    try{
    panda.feed("Bamboo");
    } catch (Exception ex){
        System.out.println(ex.getMessage());
    }
    
    cow.ageOneYear();
    cow.ageOneYear();
    cow.ageOneYear();
    cow.ageOneYear();
    cow.ageOneYear();
    
    
    System.out.println(cow);
    System.out.println(tiger);
    
    }
}
