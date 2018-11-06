/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Deque;
import csci152.adt.Queue;
import csci152.adt.SortedQueue;
import csci152.adt.Stack;

/**
 *
 * @author Sunny
 */
public class TestClass {
    
    public static void main (String [] args){
//        mergeTest();
//        queue();
//        sortedQueue();
//        deque();
//        stack();
    }
    
    public static void stack(){
        Stack<Integer> stk = new ArrayStack();
//        Stack<Integer> stk = new LLStack();
        
        try{
//            stk.pop();
            
            stk.push(12);
            stk.push(54);
            System.out.println(stk);
            
            System.out.println(stk.pop());
            System.out.println(stk);
            System.out.println(stk.getSize());
            
            stk.push(75);
            stk.push(26);
            stk.push(34);
            stk.push(10);
            stk.push(7);
            
            System.out.println(stk);
            
            for (int i = 0; i < 30; i++){
                stk.push(i);
            }
            System.out.println(stk);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void queue(){
//        Queue<Integer> q = new ArrayQueue();
        Queue<Integer> q = new LLQueue();
        
        try{
            
//            q.dequeue();
            
            q.enqueue(12);
            q.enqueue(56);
            q.enqueue(47);
            q.enqueue(85);
            System.out.println(q);
            
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q);
            
            System.out.println(q.getSize());
            
            q.clear();
            System.out.println(q);
            
            for (int i = 0; i < 20; i++){
                q.enqueue(i);
            }
            System.out.println(q);
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void sortedQueue(){
        SortedQueue<Integer> sq = new LLSQueue();
        
        try{
            sq.insert(89);
            sq.insert(12);
            sq.insert(57);
            sq.insert(46);
            sq.insert(4);
            
            System.out.println(sq);
            
            System.out.println(sq.dequeue());
            System.out.println(sq.dequeue());
            System.out.println(sq);
            
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void deque(){
        Deque<Integer> dq = new LLDeque();
        
        try{
            dq.pushToFront(36);
            dq.pushToFront(54);
            dq.pushToFront(63);
            dq.pushToFront(45);
            System.out.println(dq);
            
            dq.pushToBack(72);
            dq.pushToBack(27);
            dq.pushToBack(81);
            dq.pushToBack(18);
            System.out.println(dq);
            System.out.println("Size: " + dq.getSize());
            
            System.out.println(dq.popFromBack());
            System.out.println(dq.popFromFront());
            System.out.println(dq.popFromBack());
            System.out.println(dq.popFromFront());
            System.out.println(dq);
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }   

    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {        
	/* assuming d1 and d2 are sorted, merge their contents
       into a single sorted Deque, and return it */
       
        Deque<Integer> duo = new LLDeque();
        
        int length = d1.getSize() + d2.getSize();
                
        try{          
            while (d1.getSize() != 0 && d2.getSize() != 0){
                if (d1.getSize() > 0 && d2.getSize() > 0){
                int id1 = d1.popFromFront();
                int id2 = d2.popFromFront();
                System.out.println(id1 + " || " + id2);
                
                if (id1 < id2){
                    duo.pushToBack(id1);
                    d2.pushToFront(id2);
                    System.out.println(d1 + "\n" + d2);
                    
                } else {
                    duo.pushToBack(id2);
                    d1.pushToFront(id1);
                    System.out.println(d1 + "\n" + d2);
                }
                }
                
                System.out.println("Duo: " + duo);
            }
            
            while(d1.getSize() != 0){
                duo.pushToBack(d1.popFromFront());
            }
            
            while (d2.getSize() != 0){
                duo.pushToBack(d2.popFromFront());
            }
             
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        return duo;
} 
    
    public static void mergeTest(){
        Deque<Integer> ri = new LLDeque();
        Deque<Integer> ko = new LLDeque();
        
        for (int i = 0; i < 50; i = i * 2 + 3){
            ri.pushToBack(i);
        }
        System.out.println(ri);
        
        for (int i = 0; i < 50; i = i * 4 + 2){
            ko.pushToBack(i);
        }
        System.out.println(ko);
        
        System.out.println(merge(ri, ko));
    }
    
    public static Deque<Integer> mergeSort(Deque<Integer> deq) {
    if (deq.getSize() == 1){
        return deq;
    }
    int mid = deq.getSize() / 2;
    Deque<Integer> deq1 = new LLDeque();
    Deque<Integer> deq2 = new LLDeque();
    
    try{
    for (int i = 0; i < mid; i++){
        deq1.pushToBack(deq.popFromFront());
    }
    for (int i = 0; i < deq.getSize() - mid; i++){
        deq2.pushToBack(deq.popFromFront());
    }
    } catch (Exception ex){
        System.out.println(ex.getMessage());
    }
    
    mergeSort(deq1);
    mergeSort(deq2);
    
    
        return merge(deq1, deq2);
     /* Step 0:  base case???
        Step 1:  split deq into two Deques of relatively equal size
        Step 2:  pass both of these Deques into mergeSort
        Step 3:  pass the resulting Deques into merge, and return the result
     */
} 
    
    public static void map (){
        Stack<Integer> stk = new ArrayStack();
        
        try{
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static void hashTable(){
        Stack<Integer> stk = new ArrayStack();
        
        try{
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
