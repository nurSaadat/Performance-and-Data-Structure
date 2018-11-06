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

public class LinkedListDeque<T> implements Deque<T> {
    
    private DoublyLinkedNode<T> front;
    
    private DoublyLinkedNode<T> back;
    
    private int size;
    
    public LinkedListDeque(){
        front = null;
        back = null;
        size = 0;
    }
    
    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> temp = new DoublyLinkedNode(value);
        
        if (size > 0){
            temp.setNext(front);
            front.setPrevious(temp);
        }
        if (size == 0){
            back = temp;
        }
        front = temp;        
        size++;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> newBack = new DoublyLinkedNode(value);
        
        if (size > 0){
            back.setNext(newBack);
            newBack.setPrevious(back);
        }
        
        if (size == 0){
            front = newBack;
        }
              
        back = newBack;
        size++;        
    }

    @Override
    public T popFromFront() throws Exception {
        if (size == 0){
            throw new Exception ("The queue is empty. Add something first");
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
            throw new Exception("The queue is empty! Add something first");
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
        size = 0;
    }
    
    @Override
    public String toString(){
        String result = "Start -> ";
        DoublyLinkedNode current = front;
        
        while(current != null){
            result += current + " ,";
            current = current.getNext();
        }
        
        return result + " <- end";
    }

}