/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 * Generic doubly-linked nodes 
 * @param <T>
 */
public class DLNode<T> {
    
    private T value;
    
    private DLNode<T> previous;
    private DLNode<T> next;
    
    /**
     * Construct a doubly-linked node with the given value,
     * and null previous and next links.
     * 
     * @param val to set on the node
     */     
    public DLNode(T val){
        value = val;
        previous = null;
        next = null; 
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the previous
     */
    public DLNode<T> getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(DLNode<T> previous) {
        this.previous = previous;
    }

    /**
     * @return the next
     */
    public DLNode<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(DLNode<T> next) {
        this.next = next;
    }
    
    @Override
    public String toString(){
        return value.toString();
    }
    
}
