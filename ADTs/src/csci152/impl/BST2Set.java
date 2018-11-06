package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Sunny
 * @param <T>
 */
public class BST2Set<T extends Comparable> implements Set<T> {
    
   private OnOffTreeNode<T> root;
   private int size;
    
    public BST2Set(){
        root = null;
        size = 0;        
    }

    @Override
    public void add(T value) {
        
        if (contains(value)){
            
            return;
            
        } else {
            
        if (size == 0){
            
            root = new OnOffTreeNode<>(value);
            size++;
            
        } else {
            
            addHelper(root, value);
            
        }
        
        }
        
    }
    
    private void addHelper(OnOffTreeNode<T> node, T value){
        
        if (value.compareTo(node.getValue()) == 0){
            
            node.setActive(true);
            size++;
            
        }
        
        if (value.compareTo(node.getValue()) < 0){
            
            if (node.getLeft() == null){
                node.setLeft(new OnOffTreeNode<>(value));
                size++;
                
            } else {
                addHelper(node.getLeft(), value);
            }
        }
        
        if (value.compareTo(node.getValue()) > 0){    
            
            if (node.getRight() == null){
                node.setRight(new OnOffTreeNode<>(value));
                size++;
            } else {
                addHelper (node.getRight(), value);
            }
        }   
    }
    

    
    @Override
    public boolean contains(T value) {
        
        return containsHelper(root, value);
    }
    
    private boolean containsHelper(OnOffTreeNode<T> node, T value){
        boolean result; 
        
        if (node == null){
            result = false;
        } else {
            
            if (value.compareTo(node.getValue()) < 0){
                
                result = containsHelper(node.getLeft(), value);
            } else 
                
                if (value.compareTo(node.getValue()) == 0){
                    
                    return node.isActive();
                    
                } else {
                
                    result = containsHelper (node.getRight(), value);
                }
              
        }
        return result;
    }

    @Override 
    public boolean remove(T value){
    
        if (!contains(value)){
            
            return false;
            
        } 
            
        OnOffTreeNode focusNode = root;

        while (focusNode.getValue() != value){ 

            if (value.compareTo(focusNode.getValue()) < 0){

                focusNode = focusNode.getLeft();

            } else {

                focusNode = focusNode.getRight();

            }
        }
        
    focusNode.setActive(false);
    size --;   
    return true;  
        
} 
           
    @Override
    public T removeAny() throws Exception {
        if (size == 0){
            throw new Exception ("The set is empty! Add some values first");
        }

        OnOffTreeNode<T> focusNode = removeAnyHelp(root);
        
        T value = focusNode.getValue();
        
        return value;
    }
    
    private OnOffTreeNode<T> removeAnyHelp(OnOffTreeNode<T> node){
        
       if (node.isActive() == true){
           
            node.setActive(false);
            size --;
            return node;
            
        } else {
           
            if (node.getRight() != null && node.getLeft() == null){
                
                return removeAnyHelp(node.getRight());
                
            } else if (node.getLeft() != null && node.getRight() == null){
                
                return removeAnyHelp(node.getLeft());
                
            } else if (node.getRight() != null && node.getLeft() != null){
                
                if (node.getLeft().getLeft() == null && node.getLeft().getRight() == null){
                    
                    if (node.getLeft().isActive() == true){
                        
                        node.getLeft().setActive(false);
                        size --;
                        return node.getLeft();
                        
                    } else {
                        
                        return removeAnyHelp(node.getRight());
                    }
                    
                }
                
                return removeAnyHelp(node.getLeft());
            }
        }

        return null;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }
    
    @Override
    public String toString(){
        return toStringHelper(root);
    }
    
    private String toStringHelper(OnOffTreeNode<T> node){
        if (node == null){
            return"";
        }
        
        if (node.isActive() == false){
            
            return toStringHelper(node.getLeft())+ " " + toStringHelper(node.getRight());
            
        } else {
            
            return toStringHelper(node.getLeft()) + " " +
                    node.getValue() + " " +
                    toStringHelper(node.getRight());
        }

    }
    
}
