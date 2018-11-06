package csci152.impl;

import csci152.adt.HashTableMap;
import csci152.adt.KeyValuePair;

/**
 *
 * @author Sunny
 * @param <K>
 * @param <V>
 */
public class BSTHashTableMap<K, V> implements HashTableMap<K, V>{
    
    private TreeNode<KeyValuePair<K, V>>[] buckets;
    private int size;
    
    public BSTHashTableMap(int length){
        buckets = new TreeNode[length];
        size = 0;
    }
    
    private int helper(TreeNode<KeyValuePair<K, V>> pair){
        
        int index = Math.abs(pair.getValue().hashCode())% buckets.length;
         
        return index;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        int length = buckets.length;        
        buckets = new TreeNode[length];
        size = 0;
    }
    
    @Override
    public int getNumberOfBuckets() {
        return buckets.length;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        return gbsHelp(buckets[index]);
    }
    
    private int gbsHelp(TreeNode<KeyValuePair<K, V>> tkvp){
        if (tkvp == null){
            return 0;
        }
        return gbsHelp(tkvp.getLeft()) + 1 + gbsHelp(tkvp.getRight());
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
                try{
                mean = mean + getBucketSize(i);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
        mean = mean / getNumberOfBuckets();
        
        double sum = 0;
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets != null && buckets[i] != null){
                try{
                sum = sum + Math.pow(Math.abs(getBucketSize(i) - mean), 2);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
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
    public void define(K key, V value) {
        
        TreeNode<KeyValuePair<K, V>> add = new TreeNode(new KeyValuePair(key, value));
        
        try{
            
        if (buckets[helper(add)] == null){
            
            buckets[helper(add)] = add;
            size++;
            
        } else {
            
            defineHelper(buckets[helper(add)], key, value);
            size++;
            }
        
        } catch (Exception ex){
            System.out.println();
        }
    }
    
    private void defineHelper(TreeNode<KeyValuePair<K, V>> node, K key, V value){ 
        
        TreeNode<KeyValuePair<K, V>> addDef = new TreeNode(new KeyValuePair(key, value));
        
        if (addDef.getValue().compareTo(node.getValue()) < 0){
            
            if (node.getLeft() == null){
                node.setLeft(new TreeNode(new KeyValuePair(key, value)));
            } else {
                defineHelper(node.getLeft(), key, value);
            }
        } else if (addDef.getValue().compareTo(node.getValue()) == 0){
            
            node.getValue().setValue(value);
            
        } else {    
            
            if (node.getRight() == null){
                node.setRight(new TreeNode(new KeyValuePair(key, value)));
            } else {
                defineHelper (node.getRight(), key, value);
            }
        }   
   

        
    }

    @Override
    public V getValue(K key) {
        TreeNode<KeyValuePair<K, V>> check = new TreeNode(new KeyValuePair(key, null));
        
        if (buckets[helper(check)] == null){
            return null;
        } else {
            V result = recuriveFinder(buckets[helper(check)], key);
        }
        
        return null;
    }
    
    private V recuriveFinder(TreeNode<KeyValuePair<K, V>> root, K key){
        TreeNode<KeyValuePair<K, V>> check = new TreeNode(new KeyValuePair(key, null));
        
        if (check.getValue().compareTo(root.getValue()) < 0){
            return recuriveFinder(root.getLeft(), key);
        } else if (root.getValue().getKey().equals(key)){
            return root.getValue().getValue();
        } else {
            return recuriveFinder(root.getRight(), key);
        }
    }

    @Override
    public V remove(K key) {
        if (size == 0){
            return null;
        }
        
        TreeNode<KeyValuePair<K, V>> check = new TreeNode(new KeyValuePair(key, null));
        
        if (buckets[helper(check)] == null){
            return null;
        }
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (size == 0){
            throw new Exception("The set is empty! Add some values first");
        }
        
        KeyValuePair<K, V> result = null;
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i] != null){
                result = buckets[i].getValue();
                getReplacementNode(buckets[i]);
                break;
            }             
        }
        size--;
        return result;
    }
    
    private TreeNode<KeyValuePair<K, V>> getReplacementNode(TreeNode<KeyValuePair<K, V>> replacedNode){
        
        TreeNode<KeyValuePair<K, V>> replacementParent = replacedNode;
        TreeNode<KeyValuePair<K, V>> replacement = replacedNode;
        
        TreeNode<KeyValuePair<K, V>> focusNode = replacedNode.getRight();
        
        while (focusNode != null){
            
            replacementParent = replacement;
            
            replacement = focusNode;
            
            focusNode = focusNode.getLeft();
        }
        
        if(replacement != replacedNode.getRight()){
            
            replacementParent.setLeft(replacement.getRight());
            replacement.setRight(replacedNode.getRight());
        }
        
        return replacement;
    } 
    
@Override
    public String toString() {
        String result = "";
        
        for (int i = 0; i < buckets.length; i++){
            if (buckets[i] != null){
                result = result + toStringHelper(buckets[i]);
            }
        }
    return result; 
    }
    
    private String toStringHelper(TreeNode<KeyValuePair<K, V>> node){
        if (node == null){
            return"";
        }
        return toStringHelper(node.getLeft()) + " " +
                node.getValue() + " " + 
                toStringHelper(node.getRight())+ " ";
    }
    
}
