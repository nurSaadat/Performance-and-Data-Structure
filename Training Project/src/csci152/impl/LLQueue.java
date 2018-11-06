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
public class LLQueue<T> implements Queue<T> {
    
    private Node<T> front;
    private Node<T> back;
    private int size;
    
    public LLQueue(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        Node<T> node = new Node(value);
        if (front == null && back == null){
            front = node;
            back = node;            
        } else {
            back.setLink(node);
            back = node;
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0){
            throw new Exception("Empty queue");
        }
        T result = front.getValue();
        front = front.getLink();
        size--;
        if (size == 0){
            front = null;
            back = null;
        }
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
        Node<T> node = front;
        while (node != null){
            result = result + node.getValue() + ", ";
            node = node.getLink();
        }
        return result + "] back";
    }
    
}
