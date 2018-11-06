package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;
 
public class BSTMap<K extends Comparable, V> implements Map<K, V> {
 
    private TreeNode<KeyValuePair<K,V>> root;
    private int size;
 
    public BSTMap() {
        root = null;
        size = 0;
    }
 
    @Override
    public int getSize() {
        return size;
    }
 
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
 
    @Override
    public String toString() {
        
     return toStringHelper(root);
     
    }
    
    private String toStringHelper(TreeNode<KeyValuePair<K, V>> node){
        if (node == null){
            return"";
        }
        return toStringHelper(node.getLeft()) + " " +
                node.getValue() + " " + 
                toStringHelper(node.getRight())+ " ";
    }

    @Override
    public void define(K key, V value) {
        TreeNode<KeyValuePair<K, V>> leaf = new TreeNode(new KeyValuePair(key, value));
        
        if (size == 0){
            root = leaf;
            size++;
        } else if (getValue(key) == null){
            
            addHelper(root, key, value);
            size++;
            
        } else {
            
            addHelper(root, key, value);
            
        }       
        
    }
    
    private void addHelper(TreeNode<KeyValuePair<K, V>> node, K key, V value){
        
        if (key.compareTo(node.getValue().getKey()) < 0){
            
            if (node.getLeft() == null){
                node.setLeft(new TreeNode(new KeyValuePair(key, value)));
            } else {
                addHelper(node.getLeft(), key, value);
            }
        } else if (key.compareTo(node.getValue().getKey()) == 0){
            
            node.getValue().setValue(value);
            
        } else {    
            
            if (node.getRight() == null){
                node.setRight(new TreeNode(new KeyValuePair(key, value)));
            } else {
                addHelper (node.getRight(), key, value);
            }
        }   
    }

    @Override
    public V getValue(K key) {
        return containsHelper(root, key);
    }
    
    private V containsHelper(TreeNode<KeyValuePair<K, V>> node, K key){
        V result;        
        if (node == null){
            
            result = null;
            
        } else {
            
            if (key.compareTo(node.getValue().getKey()) < 0){
                
                result = containsHelper(node.getLeft(), key);
            } else 
                
                if (key.compareTo(node.getValue().getKey()) == 0){
                    
                    return node.getValue().getValue();
                    
                } else {
                
                    result = containsHelper (node.getRight(), key);
                }              
        }
        return result;
    }        

    @Override
    public V remove(K key) {
        
        if (getValue(key) == null){
                       
            return null;
            
        } else {
            
            TreeNode<KeyValuePair<K, V>> focusNode = root;
            TreeNode<KeyValuePair<K, V>> parent = root;
            
            boolean isItALeftChild = true;
            
            while (focusNode.getValue().getKey() != key){ 
                
                parent = focusNode;
                
                if (key.compareTo(focusNode.getValue().getKey()) < 0){
                    
                    isItALeftChild = true;
                    
                    focusNode = focusNode.getLeft();
                } else {
                    
                    isItALeftChild = false;
                    
                    focusNode = focusNode.getRight();
                }
                
                if (focusNode == null){
                    return null;
                }
            }
                
                if (focusNode.getLeft() == null && focusNode.getRight() == null){
                    
                    if (focusNode == root){
                        
                        root = null;
                        
                    } else if (isItALeftChild){
                        
                        parent.setLeft(null);
                        
                    } else {
                        
                        parent.setRight(null);
                        
                    }
                } 
                
                else if(focusNode.getRight() == null){
                    
                    if (focusNode == root){
                        root = focusNode.getLeft();
                        
                    } else if (isItALeftChild){
                        parent.setLeft(focusNode.getLeft());
                        
                    } else {
                        parent.setRight(focusNode.getLeft());
                    }
                    
                }
                
                else if(focusNode.getLeft() == null){
                    
                    if(focusNode == root){
                        root = focusNode.getRight();
                        
                    } else if (isItALeftChild){
                        parent.setLeft(focusNode.getRight());
                        
                    } else {
                        parent.setRight(focusNode.getRight());
                    }                   
                    
                }
                
                else {
                    
                    TreeNode<KeyValuePair<K, V>> replacement = getReplacementNode(focusNode);
                    
                    if(focusNode == root){
                        root = replacement;
                        
                    } else if (isItALeftChild){
                        parent.setLeft(replacement);
                        
                    } else {
                        parent.setRight(replacement);
                    }
                    
                    replacement.setLeft(focusNode.getLeft());
                } 
    size --;   
    return null;            
        }}
  
    
    
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
    public KeyValuePair<K, V> removeAny() throws Exception {
        if (size == 0){
            throw new Exception ("The set is empty! Add some values first");
        }
        
        KeyValuePair<K, V> value = root.getValue();
        
        remove(value.getKey());
        
        return value;
    }

}
