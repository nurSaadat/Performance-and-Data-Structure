package csci152.impl;

import csci152.adt.HashTableSet;

/**
 *
 * @author Sunny
 */
public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T>{
    
    private BSTSet<T>[] buckets;
    private int size;
    
    /*
    One other thing to remember — although we can make easy use of the add and 
    remove methods of the BSTSet buckets to add and remove items from the whole 
    Set, we still need to properly update the overall size of the Set. 
    Remember in some cases that a call to add or remove may not actually 
    modify the size of the Set.
    */
    
    public BSTHashTableSet(int length){
        buckets = new BSTSet[length]; 
        size = 0;
    }
    
    private int helper(Object value){
        
        int index = Math.abs(value.hashCode()) % buckets.length;
        
        return index;
    }

    @Override
    public T removeAny() throws Exception {
        if (size == 0){
            throw new Exception("The set is empty! Add some values first");
        }
        
        T result = null;
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i] != null && buckets[i].getSize() != 0){
                result = buckets[i].removeAny();
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
        buckets = new BSTSet[length];
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

    @Override
    public void add(T value) {
    if (contains(value)){            
    
    } else 
        if (buckets[helper(value)] == null){
            
            buckets[helper(value)] = new BSTSet<>();
            buckets[helper(value)].add(value);
            size ++;
                
            } else {
            buckets[helper(value)].add(value);
            size++;
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
        
        return buckets[helper(value)].contains(value);
        
    }

    @Override
    public boolean remove(T value) throws Exception {
        if (size == 0){
            return false;
        }
        
        if (buckets[helper(value)].getSize() == 0){
            return false;
        }
        
        if (!contains(value)){
            return false;
        } else {
            buckets[helper(value)].remove(value);
            size--;
            return true;
        }
    }
    
}
