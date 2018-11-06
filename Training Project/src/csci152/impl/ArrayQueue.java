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
    private int front;
    private int back;
    private int size;
    
    public ArrayQueue(){
        values = (T[]) new Object[10];
        size = 0;
        front = 0;
        back = 0;
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
    
    @Override
    public String toString(){
        String result = "front [";
        for (int i = front; i < back; i++){
            result = result + values[i] + ", ";
        }
        return result + "] back";
    }

    @Override
    public void enqueue(T value) {
        
        if (size == values.length){
            T[] temp = (T[]) new Object[values.length * 2];
            
            if (front == 0){
                for (int i = 0; i < values.length; i++){
                    temp[i] = values[i];
                }
            } else {
                for (int i = 0; i < back; i++){
                    temp[i] = values[i];
                }
                for (int k = 0; k <= front; k++){
                    temp[temp.length - k] = values[values.length - k];
                }
                    
            }
            values = temp;
        }
                back = (back + 1) % values.length;
        values[back] = value;
        size++;

    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0){
            throw new Exception("Empty queue");
        }
        T result = values [front];
        values [front] = null;
        front = (front + 1) % values.length;
        size--;
        return result;
    }
    
}
