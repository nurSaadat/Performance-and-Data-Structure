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

public class LinkedListQueue<T> implements Queue<T> {
    
    private Node<T> front;
    
    private Node<T> back;
    
    private int size;
    
    public LinkedListQueue(){
        front = null;
        back = null;
        size = 0;
    }
    
    @Override
    public void enqueue(T value) {
        Node<T> newBack = new Node(value);
        
        if (size > 0){
            back.setLink(newBack);
        }
        
        if (size == 0){
            front = newBack;
        }
              
        back = newBack;
        size++;        
    }

    @Override
    public T dequeue() throws Exception { 
        if (size == 0){
            throw new Exception ("The queue is empty. Add something first");
        }
        
        T result = front.getValue();
        
        if (size > 1){
            front = front.getLink();
        }
        if (size == 1){
            front = null;
            back = null;
        }
        size--;
        
        return result;
    }
 
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        
        front = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String result = "front[";
        Node current = front;
        
        while(current != null){
            result += current + ", ";
            current = current.getLink();
        }
        
        return result + "]back ";
    }

    
}