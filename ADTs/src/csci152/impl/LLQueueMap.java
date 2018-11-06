package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

/**
 *
 * @author Sunny
 * @param <K>
 * @param <V>
 */
public class LLQueueMap<K, V> implements Map<K, V>{
    
    private LinkedListQueue<KeyValuePair<K, V>> pairs;
    
    public LLQueueMap() {
        pairs = new LinkedListQueue();
    }

    @Override
    public void define(K key, V value) {
        if (getValue(key) == null){
            
            KeyValuePair<K, V> kvp = new KeyValuePair(key, value);
            pairs.enqueue(kvp);  
            
        } else {
            
            for (int i = 0; i < pairs.getSize(); i++){
                
                try {                
                    
                KeyValuePair<K,V> match = pairs.dequeue();
                
                if (key != match.getKey()){
                    
                    pairs.enqueue(match);
                    
                } else {
                    
                    KeyValuePair<K, V> kvp = new KeyValuePair(key, value);
                    pairs.enqueue(kvp);
                    
                }
                
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            
        }
        
    }

    @Override
    public V getValue(K key) {
        if (pairs.getSize() == 0){
            return null;
        } else {
            for (int i = 0; i < pairs.getSize(); i++){
                
                try {
                    
                KeyValuePair<K, V> match = pairs.dequeue();
                pairs.enqueue(match);
                
                if (key.equals(match.getKey())){
                    
                    return match.getValue();
                }
                
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                
            }    
            
            return null;
        }
        
    }

    @Override
    public V remove(K key) {
        if (pairs.getSize() == 0){
            return null;
        } else {
            for (int i = 0; i < pairs.getSize(); i++){
                
                try {
                    
                KeyValuePair<K, V> match = pairs.dequeue();
                
                
                if (key.equals(match.getKey())){
                    
                    return match.getValue();
                    
                } else {
                    
                    pairs.enqueue(match);
                    
                }
                
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                
            }    
            
            return null;
        }
        
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (pairs.getSize() == 0){
            
            throw new Exception("No items in the Map"); 
            
        }
        
        KeyValuePair<K, V> kvp = pairs.dequeue();
                
        return kvp;
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue();
    }
    
    @Override
    public String toString(){
        return pairs.toString();
    } 
    
}
