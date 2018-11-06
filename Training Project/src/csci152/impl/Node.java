/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 * Generic node class for creating linked-lists
 * @author Sunny
 * @param <T>
 */
public class Node<T> {
    
    private T value;
    private Node<T> link;
    
    /**
     * Constructs a node with the given value, and a null link 
     * @param val to set on the node
     */
    public Node(T val){
        value = val;
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
     * @return the link
     */
    public Node<T> getLink() {
        return link;
    }
    
    /**
     * @param link the link to set
     */
    public void setLink(Node<T> link) {
        this.link = link;
    }
    
    /**
     * @return the string representation of the value
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
