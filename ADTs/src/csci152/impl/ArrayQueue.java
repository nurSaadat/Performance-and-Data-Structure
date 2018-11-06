/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;
import csci152.adt.Queue;

/**
 *
 * @author Sunny
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T>{
    
    private T[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayQueue(){
        values = (T[]) new Object[5];
        size = 0;
        front = 0;
        back = -1;
    }
    
    @Override
    public void enqueue(T value) {
        
        if (size == values.length){
            T[] newArray = (T[]) new Object[values.length * 2]; 
            
            if(front == 0){
                for (int i = 0; i < values.length; i++) {
                    newArray[i] = values[i];
                }
            } else {
                for (int i = 0; i < back; i++){
                    newArray[i] = values[i];
                }
                for (int i = 0; i <= front; i++){
                    newArray[newArray.length - i] = values[values.length - i];
                }
            }
            
            values = newArray;
        }    
        
        if (back == -1){
            back = 0;
        } else {
            back = (back + 1) % values.length;
        }
        
        values[back] = value;
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        
        if (size == 0){
            throw new Exception ("Nothing in queue! Please, enter some values first!");
        }
        
        T result = values[front];
        values[front] = null;
        front = (front + 1) % values.length;
        
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
        front = 0;
        back = -1;
    }
    
    public String toString(){
        String hee = "Front >";
        for (int i = front; i <=back; i++){
            hee = hee + values[i] + " : ";
        }
        return hee + " < Back";
    }
    
}
