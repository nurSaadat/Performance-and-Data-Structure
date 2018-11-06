/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstjavaprog;

/**
 *
 * @author Sunny
 */
public class Pet {
    
    private String name;
    
    public Pet(String n) {
        name = n;
    }
    
    public String getName() {
        return name;
    }
    
    public void eat() {
        System.out.println("Nom, nom...");
    }
    
    public String toString() {
        return "Animal named " + name;
    }
}
