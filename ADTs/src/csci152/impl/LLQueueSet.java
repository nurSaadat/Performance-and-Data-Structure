package csci152.impl;

import csci152.adt.Set;

/**
 * @author Sunny
 * @param <T>
 */

public class LLQueueSet<T> 
        implements Set<T> {
    
     private LinkedListQueue<T> queue;
    
    public LLQueueSet(){
        queue = new LinkedListQueue<>();
    }
    
     @Override
    public void add(T value) {      
        if (!contains(value)) {
           queue.enqueue(value);
       }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < queue.getSize(); i++){
            try {
                T x = queue.dequeue();
                queue.enqueue(x);
                
                if (x.equals(value)){
                    return true;
                }
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }        
        return false;
    }

    @Override
    public boolean remove(T value){
        if (queue.getSize() == 0){
            return false;
        }
        if (contains(value)){
            for (int i = 0; i < queue.getSize(); i++){
                try {
                T x = queue.dequeue();
                              
                    if (!x.equals(value)){
                        queue.enqueue(x);
                    }
                    
                } catch (Exception ex){
                System.out.println(ex.getMessage());
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (queue.getSize() == 0){
            throw new Exception ("The set is empty! Add some values first");
        }
        
        return queue.dequeue();
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue = new LinkedListQueue();
    }
    
    @Override
    public String toString(){
        return "" + queue;
    }

}