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
public class Dog extends Pet {
    
    private boolean isBig;
    
    public Dog(String n, boolean bg) {
        super(n);
        isBig = bg;
    }
    
    public void bark() {
        if (isBig) {
            System.out.print("WOOF!!!");
        } else {
            System.out.println("guf, guf.");
        }
    }
    
    public void eat() {
        if (isBig) {
            System.out.println("MUNCH, SLURP!!!");
        } else {
            System.out.println("chomp, chomp.");
        }
    }
    
    public String toString(){
        return "Dog named " + getName();
    }
}
