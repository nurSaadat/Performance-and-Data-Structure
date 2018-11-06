/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstlabproj;

/**
 *
 * @author Sunny
 */
public class Box {
    
    //Fields
    private int height;
    private int length;
    private int width;
    
    // Constructor 
    public Box (int l, int w, int h) {
        length = l;
        width = w;
        height = h;
    }
    
    public int findVolume () {
        return length * height * width;
    }
    
    public int findSurfaceArea () {
        return 2*(length*height) + 2*(length*width) + 2*(height*width);
    }
    
    @Override
    public String toString(){
        return "Box dimentions: " + length + " x " + width + " x " + height;
    }
}
