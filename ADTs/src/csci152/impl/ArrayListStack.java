package csci152.impl;

import csci152.adt.Stack;
import java.util.ArrayList;

/**
 *
 * @author Sunny
 * @param <T>
 */
public class ArrayListStack<T> implements Stack<T>{
    ArrayList<T> stk = new ArrayList();

    @Override
    public void push(T value) {
        
        stk.add(0, value);
    }

    @Override
    public T pop() throws Exception {
        
        if(stk.isEmpty()){
            throw new Exception("No items in the stack");
        }
        return stk.remove(0);
        
    }

    @Override
    public int getSize() {
        return stk.size();
    }

    @Override
    public void clear() {
        stk = new ArrayList();
    }
    
    @Override
    public String toString(){
        return stk.toString() + "Size: " + getSize();
    }
    
}
