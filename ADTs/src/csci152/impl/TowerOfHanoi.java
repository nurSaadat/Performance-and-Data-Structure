
package csci152.impl;

import csci152.adt.Stack;

public class TowerOfHanoi {

	private Stack<Integer>[] post = new ArrayStack[3];
	private int numMoves = 0;
	
	public TowerOfHanoi(int numDiscs) {
		
                for (int i = 0; i < 3; i++){
                    post[i] = new ArrayStack();
                }
                for (int i = numDiscs; i > 0; i--){
                    post[0].push(i);
                }
	}
	
	public void moveDisc(int from, int to) throws Exception {
		
                if (from > 2 || from < 0 || to > 2 || to < 0){
                    
                    throw new Exception ("The index must be in the range from 0 to 2");                  
               
                }
                
                int move, top;
                
                try { 
                    
                    move = post[from].pop();
                    
                } catch (Exception e) {
                    
                   throw new Exception("The \"from\" stack is empty"); 
                    
                }
                
                try {
                    
                    top = post[to].pop();
                    
                } catch (Exception e) {
                    
                    post[to].push(move);
                    numMoves++;
                    return;
                }
                
                if (move < top){
                    
                    post[to].push(top);
                    post[to].push(move);
                    numMoves++;
                    
                } else {
                    
                    post[from].push(move);
                    post[to].push(top);
                    throw new Exception("This move is illegal");
                    
                }
	}
	
	public boolean isFinished() {
		
                if (post[0] == null && post[1] == null){
                    
                    return true;
                    
                } else { 
                    
		return false;
                
                }
	}
	
	public int getNumMoves() {
		return numMoves;
	}
	
	public String toString() {
		String result = "";
                for (int i = 0; i < post.length; i++){
                    result = result + "Post" + i + ": " + post[i].toString() + "\n";
                }
		return result;
	}
	
}

