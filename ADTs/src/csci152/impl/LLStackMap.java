package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

/**
 *
 * @author Sunny
 * @param <K>
 * @param <V>
 */
public class LLStackMap<K, V> implements Map<K, V>{
    
    private LinkedListStack<KeyValuePair<K, V>> pairs;
    
    public LLStackMap() {
        pairs = new LinkedListStack();
    }    
    
    @Override
    public void define(K key, V value) {
        
        if (getValue(key) == null){
            
            pairs.push(new KeyValuePair (key, value));
            
        } else {
            
            try{
            
            LinkedListQueue<KeyValuePair<K, V>> gg = new LinkedListQueue();
            
            for (int i = 0; i < pairs.getSize(); i++) {  
                    
                KeyValuePair<K, V> kvp = pairs.pop();
                
                if (key.equals(kvp.getKey())){
                    
                    gg.enqueue(new KeyValuePair (key, value));
                    
                } else {
                    
                    gg.enqueue(kvp);
                    
                }   
            }
            
            int size = gg.getSize();
            
            for (int i = 0; i < size; i++){
                
                pairs.push(gg.dequeue());
            }
            
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
        }
    }

    @Override
    public V getValue(K key) {
        if (pairs.getSize() == 0){
            
            return null;
            
        } else {
            
            V result = null;
            
            try{
            
            LinkedListQueue<KeyValuePair<K, V>> gg = new LinkedListQueue();
            
            int sizeS = pairs.getSize();
            
            for (int i = 0; i < sizeS; i++) {  
                    
                KeyValuePair<K, V> kvp = pairs.pop();
                
                if (key.equals(kvp.getKey())){
                    
                    gg.enqueue(kvp);
                    result = kvp.getValue();
                    
                } else {
                    
                    gg.enqueue(kvp);
                    
                }   
            }
            
            int sizeQ = gg.getSize();
            
            for (int i = 0; i < sizeQ; i++){
                
                pairs.push(gg.dequeue());
            }
            
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            
            return result;
        }
        
    }

    @Override
    public V remove(K key) {
        
        if (pairs.getSize() == 0){
            
            return null;       
            
        } else {
            
            V result = null;
            
            try{
            
            LinkedListQueue<KeyValuePair<K, V>> gg = new LinkedListQueue();
            
            int sizeS = pairs.getSize();
            
            for (int i = 0; i < sizeS; i++) {  
                    
                KeyValuePair<K, V> kvp = pairs.pop();
                
                if (key.equals(kvp.getKey())){
                    
                    result = kvp.getValue();
                    break;
                    
                } else {
                    
                    gg.enqueue(kvp);
                    
                }   
            }
            
            int sizeQ = gg.getSize();
            
            for (int i = 0; i < sizeQ; i++){
                
                pairs.push(gg.dequeue());
            }
            
            } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            
            return result;
        }
        
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        
        if (pairs.getSize() == 0){
            
            throw new Exception("No items in the Map.");
            
        }
        
        return pairs.pop();
        
    }    

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListStack();
    }
    
    @Override
    public String toString(){
        return pairs.toString();
    }     
}
