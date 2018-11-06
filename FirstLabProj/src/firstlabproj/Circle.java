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
public class Circle {
    
    // Fields
    private double radius;
    
    // Constructor
    public Circle (double r){
        radius = r;
    }
    
    //Methods
    public double findCircumference () {
        return 2*radius*3.14;
    }
    
    public double findArea () {
        return 3.14*radius*radius;
    }
    
    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }
    
}
