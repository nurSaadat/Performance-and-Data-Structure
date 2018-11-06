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
public class Tiger extends AnimalImpl {

   
    @Override
    public String animalKind() {
        return "Tiger";
    }

   
    @Override
    public boolean canEat(String food) {
        if(food.equals("Meat")){
            return true;
        }
        return false;
    }

    @Override
    public void feed(String food) throws Exception {
        if (!this.canEat(food)){
            throw new Exception ("Tigers can not eat " + food);
        }
        System.out.println("MUNCH MUNCH");
    }

    @Override
    public void makeNoise() {
        System.out.println("RRROARRRR");
    }
    
    public String toString(){
        return super.toString() ;
    }    
}
