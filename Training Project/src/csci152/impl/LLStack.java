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
public class LLStack<T> implements Stack<T> {
    
    private Node<T> top;
    private int size;
    
    public LLStack(){
        top = null;
        size = 0;
    }

    @Override
    public void push(T value) {
        Node<T> node = new Node(value);
        
        if (top != null){
            node.setLink(top);
        }
        
        top = node;
        
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size == 0){
            throw new Exception("Empty stack");
        }
        T result = top.getValue();
        top = top.getLink();
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
        Node<T> node = top;
        String result = "top [";
        while (node != null){
            result = result + node.getValue() + ", ";
            node = node.getLink();
        }
        return result + "] bottom";
    }
    
}
