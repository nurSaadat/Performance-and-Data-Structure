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
public class Train {
    
    private Engine engine;
    
    public Train(String ename, String carg, int cabID) {
        
        engine = new Engine(ename);
        engine.setBoxcar(new Boxcar(carg));
        engine.getBoxcar().setCaboose(new Caboose(cabID));
    }
    
    public String toString() {
        return "Train " + engine.toString() + " " +
                engine.getBoxcar().toString() + " " +
                engine.getBoxcar().getCaboose().toString();
    }
}
