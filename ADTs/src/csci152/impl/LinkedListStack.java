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

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    
    public LinkedListStack(){
        top = null;
        size = 0;
    }
    
    @Override
    public void push(T value) {
        Node<T> temp = new Node(value);
        if (size > 0){
            temp.setLink(top);
        }
        top = temp;
        size++;
    }

    @Override
    public T pop() throws Exception {
       if(size == 0){
           throw new Exception("Stack is empty");
       }
       T result = top.getValue(); 
       if( size == 1){
           top = null;
       } else {
       
        top.setValue(top.getLink().getValue());
        top.setLink(top.getLink().getLink());                 
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
        top = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String result = "Start -> ";
        Node current = top;
        
        while(current != null){
            result += current + " ,";
            current = current.getLink();
        }
        
        return result + " <- end";
    }
}