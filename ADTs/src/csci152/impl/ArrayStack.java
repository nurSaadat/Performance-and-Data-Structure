/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 *
 * @author Sunny
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T>{
     
    private T[] values;
    private int size;
    
   /*
    double size
    */
    public ArrayStack() {
        values = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public void push(T value) {
        this.values[size] = value;
        size++;
        
        if(size == values.length){           
            
            T[] newArray = (T[]) new Object[values.length * 2]; 
            for (int i = 0; i < values.length; i++) {
                    newArray[i] = values[i];
                }
            values = newArray;
            
        }
    }

    @Override
    public T pop() throws Exception {
        size--;
        if (size < 0){
            size = 0;
            throw new Exception("No items in the stack");
        }
        T result = values [size];
        
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[]) new Object[10];
        size = 0;
    }
    
    @Override
    public String toString(){
        String hee = "bottom [";       
        for (int i = 0; i < size; i++){
             hee = hee + values[i] + ":";
        }
        return hee + "]top";
    }
    
    
}
