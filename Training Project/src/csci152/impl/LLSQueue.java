/*
*
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
public class LLSQueue<T extends Comparable> implements SortedQueue<T> {
    
    private Node<T> front;
    private int size;
    
    public LLSQueue(){
        front = null;
        size = 0;
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

    @Override
    public void insert(T value) {
        Node<T> node = new Node(value);
        if (size == 0){
            front = node;
        } else {
            if (value.compareTo(front.getValue()) <= 0){
                node.setLink(front);
                front = node;
            } else if (node.getValue().compareTo(front.getValue()) > 0){
                Node<T> compare = front;
                while(compare.getLink() != null && value.compareTo(compare.getLink().getValue()) > 0){
                    compare = compare.getLink();
                }
                node.setLink(compare.getLink());
                compare.setLink(node);
            }
        }
        size++;
    }
    
    
}
