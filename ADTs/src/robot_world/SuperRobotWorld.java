
package robot_world;

import java.io.IOException;
import csci152.adt.Stack;
import csci152.impl.ArrayStack;


public class SuperRobotWorld extends RobotWorld {

	// TODO: Add some fields to keep track of commands
    
    public static final char MOVE = 'M';
    public static final char CLOCKWISE = 'C';
    public static final char COUNTERCLOCKWISE = 'O';
    
    private Stack<Character> was = new ArrayStack<>();
    private Stack<Character> will = new ArrayStack<>();
    
	
    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);
    }
    
    @Override
    public void moveForward(){
        
        try {
            
            was.push(MOVE);
            super.moveForward();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
    
    }
    
    @Override
    public void rotateCounterClockwise() {
        
        was.push(COUNTERCLOCKWISE);
        super.rotateCounterClockwise();
        
    }
    
    @Override
    public void rotateClockwise() {
        
        was.push(CLOCKWISE);
        super.rotateClockwise();
        
    }
    
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    public void undoCommand() {
        
        try {
            
        char toDo = was.pop();
        
        if (toDo == MOVE){
            
            super.rotateClockwise();
            super.rotateClockwise();
            super.moveForward();
            super.rotateClockwise();
            super.rotateClockwise();
            
        }
        
        if (toDo == CLOCKWISE){
            
            super.rotateCounterClockwise();
            
        }
        
        if (toDo == COUNTERCLOCKWISE){
            
            super.rotateClockwise();
            
        }
            
        will.push(toDo);
        
        } catch (Exception e) {
            
        } 
    }
    
    /**
     * Undo the last n commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to undo
     */
    public void undoCommands(int n) {
    	
        for (int i = 0; i < n; i++){
            
            undoCommand();
            
        }
        
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
        try {
        
        char toDo = will.pop();
        
        if (toDo == MOVE){
            
            super.moveForward();
            
        }
        
        if (toDo == CLOCKWISE){
            
            super.rotateClockwise();
            
        }
        
        if (toDo == COUNTERCLOCKWISE){
            
            super.rotateCounterClockwise();
            
        }
            
        was.push(toDo);
        
        } catch (Exception e) {
            
        }        
    }
    
    /**
     * Redo the last n undone commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to redo
     */
    public void redoUndoneCommands(int n) {
        
    	 for (int i = 0; i < n; i++){
            
            redoUndoneCommand();
            
        }
    }
}
