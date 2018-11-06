package csci152.impl;

/**
 *
 * @author Sunny
 */
public class GameCheck {
    
    public static void main (String [] args){
        int n = 5;
        TowerOfHanoi tower = new TowerOfHanoi(n);
        bestSolution(tower, n, 0, 1, 2);
        System.out.println("Moves done: " + tower.getNumMoves() + " || " + tower.toString());
    }
    
      
    public static void bestSolution(TowerOfHanoi tower, int n, int stor, int temp, int targ) {
		
        if (n == 1) {			
            try {				
                    tower.moveDisc(stor, targ);				
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
        } else {
            
            bestSolution(tower, n - 1, stor, targ, temp);
            try {				
                    tower.moveDisc(stor, targ);				
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
            bestSolution(tower, n - 1, temp, stor, targ);
            
        }
                

        }

}
