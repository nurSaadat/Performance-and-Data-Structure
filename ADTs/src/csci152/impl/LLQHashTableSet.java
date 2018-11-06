package csci152.impl;

import csci152.adt.HashTableStats;
import csci152.adt.Set;

/**
 *
 * @author Sunny
 * 
*/

public class LLQHashTableSet<T> implements Set<T>,
        HashTableStats{
    
    private LinkedListQueue<T>[]buckets;
    private int size;
    
    public LLQHashTableSet(int length){
        buckets = new LinkedListQueue[length];
        size = 0;
    }
    
    private int helper(T value){
        
        int index = Math.abs(value.hashCode()) % buckets.length;
        
        return index;
    }

    @Override
    public void add(T value) {
        
        if (contains(value)){

        } else {            
            if (buckets[helper(value)] == null){
                
                buckets[helper(value)] = new LinkedListQueue<>();
                buckets[helper(value)].enqueue(value);
                size ++;
                
            } else {
                
                for (int i = 0; i < buckets[helper(value)].getSize(); i++){
                    
                    try {
                        
                    T x =  buckets[helper(value)].dequeue();
                     buckets[helper(value)].enqueue(x);
                     
                     if (x.equals(value)){
                         return;
                     }
                    
                    } catch (Exception ex){
                        
                        System.out.println(ex.getMessage());
                    }
                    
                }
                buckets[helper(value)].enqueue(value);
                size++;
                
            }
            
        }

    }

    @Override
    public boolean contains(T value) {
        if (size == 0){
            
            return false;
        }
        
        if (buckets[helper(value)] == null){
            
            return false;
        }
        
        for (int i = 0; i < buckets[helper(value)].getSize(); i++){
            try {
                T x = buckets[helper(value)].dequeue();
                buckets[helper(value)].enqueue(x);
                
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
    public boolean remove(T value) throws Exception {
        if (size == 0){
            return false;
        }
        
        if (buckets[helper(value)].getSize() == 0){
            return false;
        }

        if (contains(value)){
            for (int i = 0; i < buckets[helper(value)].getSize(); i++){
                try {
                T x = buckets[helper(value)].dequeue();

                    if (!x.equals(value)){
                        buckets[helper(value)].enqueue(x);
                    }

                } catch (Exception ex){
                System.out.println(ex.getMessage());
                }
            }
            size--;
            return true;
        }
        return false;}

    @Override
    public T removeAny() throws Exception {
        if (size == 0){
            throw new Exception("The set is empty! Add some values first");
        }
        
        T result = null;
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i].getSize() != 0){
                result = buckets[i].dequeue();
                break;
            }             
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
        int length = buckets.length;        
        buckets = new LinkedListQueue[length];
        size = 0;
    }
    
    public String toString(){
        String line = "";
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i] != null){
                line = line + buckets[i].toString();
            }
        }
        
        return line;
    }

    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if (index < 0){
            throw new Exception("Invalid index provided. "
                    + "Index value shoud be more than zero");
        }
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return getSize()/getNumberOfBuckets();
    }

    @Override
    public double getBucketSizeStandeardDev() {
        double mean = 0;
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets != null && buckets[i] != null){
                mean = mean + buckets[i].getSize();
            }
        }
        
        mean = mean / buckets.length;
        
        double sum = 0;
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets != null && buckets[i] != null){
                sum = sum + Math.pow(Math.abs(buckets[i].getSize() - mean), 2);
            }
        }
        
        return Math.sqrt(sum/buckets.length);
    }

    @Override
    public String bucketsToString() {
        String result = "";
        
        for (int i = 0; i < buckets.length; i++){
            result = result + "bucket #" + i+1 + ": " + buckets[i].toString() + "\n";
        }
        
        return result;
    }
}
