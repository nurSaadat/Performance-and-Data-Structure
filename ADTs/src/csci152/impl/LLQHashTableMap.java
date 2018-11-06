package csci152.impl;

import csci152.adt.HashTableMap;
import csci152.adt.KeyValuePair;

/**
 *
 * @author Sunny
 * @param <K>
 * @param <V>
 */
public class LLQHashTableMap<K, V> implements HashTableMap<K, V>{
    
    private LinkedListQueue<KeyValuePair<K, V>>[] buckets;
    private int size;
    
    public LLQHashTableMap(int length){
        
        buckets = new LinkedListQueue[length];
        size = 0;
        
    }
    
    private int helper(KeyValuePair<K, V> pair){
        
        int index = Math.abs(pair.hashCode()) % buckets.length;
         
        return index;
    }
    
     @Override
    public void define(K key, V value) {
        
        KeyValuePair<K, V> add = new KeyValuePair(key, value);
        
        if (getValue(key) == null){
      
        
        if (buckets[helper(add)] == null){
            
            buckets[helper(add)] = new LinkedListQueue();
            buckets[helper(add)].enqueue(add);
            size++;
            
        } else {
            
            buckets[helper(add)].enqueue(add);
            size++;
            
        }
        } else {
            
            for(int i = 0; i < buckets[helper(add)].getSize(); i++){
                
                try{
                
                KeyValuePair<K, V> check = buckets[helper(add)].dequeue();
                
                if (key.equals(check.getKey())){
                    buckets[helper(add)].enqueue(add);
                } else {
                    buckets[helper(add)].enqueue(check);
                }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            
            
        }       
        
    }

    @Override
    public V getValue(K key) {
        if (size == 0){
            return null;
        }
        V result = null;
                
        KeyValuePair<K, V> cap = new KeyValuePair(key, null);
        
        if (buckets[helper(cap)] == null){
            return null;
        } else {
        
        for (int i = 0; i < buckets[helper(cap)].getSize(); i++){
            try {
                
            KeyValuePair<K, V> check = buckets[helper(cap)].dequeue();
            buckets[helper(cap)].enqueue(check);
            
            if (key.equals(check.getKey())){
                
                result = check.getValue();
            }
            
            } catch (Exception ex) {
                
                System.out.println(ex.getMessage());
            } 
        }
        
        return result;
        
        }
    
    }    
    
    @Override
    public V remove(K key) {
        if (size == 0){
            return null;
        }
        
        if (getValue(key) == null){
            return null;
        }
        
        V result = null;
                
        KeyValuePair<K, V> cap = new KeyValuePair(key, null);
      
        for (int i = 0; i < buckets[helper(cap)].getSize(); i++){
            try {
                
            KeyValuePair<K, V> check = buckets[helper(cap)].dequeue();
                        
            if (key.equals(check.getKey())){
                
                result = check.getValue();
                size--;
                break;
            } else {
                
                buckets[helper(cap)].enqueue(check);
            }
            
            } catch (Exception ex) {
                
                System.out.println(ex.getMessage());
            } 
        }
        
        return result;
        
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (size == 0){
            throw new Exception("The set is empty! Add some values first");
        }
        
        KeyValuePair<K, V> result = null;
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i] != null && buckets[i].getSize() != 0){
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
        
        mean = mean / getNumberOfBuckets();
        
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
