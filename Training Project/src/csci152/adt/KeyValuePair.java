package csci152.adt;

import java.util.Objects;

/**
 *Key-value pairs to be used with the Map interface
 * @param <K>
 * @param <V>
 */
public class KeyValuePair<K, V> implements Comparable{
    
    private K key;
    private V value;
    
    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(V value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "<" + key + ", " + value + ">";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.key);
        return hash;
    }
    
    @Override
    public boolean equals (Object obj){
        if (obj instanceof KeyValuePair){
            KeyValuePair kvpobj = (KeyValuePair) obj;
            return key.equals(kvpobj.key);
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        KeyValuePair<K, V> stobj = (KeyValuePair) o;
        
        if ((Integer) key < (Integer) stobj.getKey()){
            return -1;
        } else if (Objects.equals(key, stobj.getKey())){
            return 0;
        } else {
            return 1;
        }
        
    }
    
}
