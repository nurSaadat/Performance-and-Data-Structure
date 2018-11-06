/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Deque;

/**
 *
 * @author Sunny
 * @param <T>
 */
public class LLDeque<T> implements Deque<T>{
    
    private DLNode<T> front;
    private DLNode<T> back;
    private int size;
    
    public LLDeque(){
        front = null;
        back = null;
        size = 0;
    }    

    @Override
    public void pushToFront(T value) {
        DLNode<T> node = new DLNode(value);
        if (size == 0){
            back = node;           
        } else {
            node.setNext(front);
            front.setPrevious(node);
        }      
        front = node;
        size ++;
    }

    @Override
    public void pushToBack(T value) {
        DLNode<T> node = new DLNode(value);
        if (size == 0){
            front = node;           
        } else {
            back.setNext(node);
            node.setPrevious(back);            
        }      
        back = node;
        size ++;
    }

    @Override
    public T popFromFront() throws Exception {
        if (size == 0){
            throw new Exception("Empty deque");
        }
        T result = front.getValue();
        if (size > 1){
        front.getNext().setPrevious(null);
        front = front.getNext();
        }
        if (size == 1){
            front = null;
            back = null;
        }
        size--;
        return result;
    }

    @Override
    public T popFromBack() throws Exception {
        if (size == 0){
            throw new Exception("Empty deque");
        }
        T result = back.getValue();
        if (size > 1){
        back.getPrevious().setNext(null);
        back = back.getPrevious();
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
        back = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String result = "front [";
        DLNode<T> current = front;
        while(current != null){
            result = result + current.getValue() + ", ";
            current = current.getNext();
        }
        return result + "] back";
    }
    
}
