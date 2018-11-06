/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainproject;

/**
 *
 * @author Sunny
 */
public class Engine {
    
    private String name;
    private Boxcar boxcar;
    
    public Engine(String name){
        this.name = name;
        boxcar = null;
    }
    
    public void setBoxcar(Boxcar bcar){
        boxcar = bcar;
    }
    
    public Boxcar getBoxcar(){
        return boxcar;
    }
    
    public String toString() {
        return "Engine" + name;
    }
    
}
