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
public class Boxcar {
    
    private String cargo;
    private Caboose caboose;
    
    public Boxcar(String cargo){
        this.cargo = cargo;
        caboose = null;
    }
    
    public void setCaboose(Caboose cab){
        caboose = cab;
    }
    
    public Caboose getCaboose(){
        return caboose;
    }
    
    public String toString(){
        return "Boxcar is carrying " + cargo;
    }
}
