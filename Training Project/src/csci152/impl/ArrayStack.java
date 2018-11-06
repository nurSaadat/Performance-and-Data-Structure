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
    
    public ArrayStack(){
        values = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public void push(T value) {
        
        if (size == values.length){
            T[] temp = (T[]) new Object[values.length * 2];
            for (int i = 0; i < values.length; i++){
                temp[i] = values[i];
            }
            values = temp;
        }
        
        values[size] = value;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0){
            throw new Exception("Empty stack");
        }
        T result = values[size - 1];
        values[size - 1] = null;
        size--;
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
        String result = "bottom [";
        for (int i = 0; i < size; i++){
            result = result + values[i] + ", ";
        }
        return result + "] top";
    }
    
}
