/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.SortedQueue;


/**
 *
 * @author Sunny
 * @param <T>
 */

public class LinkedListSortedQueue<T extends Comparable> 
        implements SortedQueue<T> {
    
    private Node<T> front;
    
    private int size;
    
    public LinkedListSortedQueue(){
        front = null;
        size = 0;
    }
    
    public void insert (T value) {
        Node<T> newItem = new Node(value);
        
        if (size == 0){
            front = newItem;
        } else {
            //newIt goes before front
            if (value.compareTo(front.getValue()) <= 0){
                newItem.setLink (front);
                front = newItem;
            }
            //new it goes middle
            if (value.compareTo(front.getValue()) > 0){
                Node  compare = front;
                while (compare.getLink() != null && value.compareTo(compare.getLink().getValue()) > 0){
                    compare = compare.getLink();
                }
                newItem.setLink(compare.getLink());
                compare.setLink(newItem);
            }
            //new item goes at the end
        }
        
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
        Node current = front;
        
        while(current != null){
            result += current + " ,";
            current = current.getLink();
        }
        
        return result + " <- end";
    }

    
}