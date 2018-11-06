package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Sunny
 */
public class BSTSet<T extends Comparable> implements Set<T> {
    
    private TreeNode<T> root;
    private int size;
    
    public BSTSet(){
        root = null;
        size = 0;
    }

    @Override
    public void add(T value) {
        
        if (contains(value)){
            return;
        } 
            
        TreeNode<T> leaf = new TreeNode<>(value);
            
        if (size == 0){
            
            root = leaf;
        } else {
            
            addHelper(root, value);
        }
                
        size++;
        
    }
    
    private void addHelper(TreeNode<T> node, T value){
        
        if (value.compareTo(node.getValue()) < 0){
            
            if (node.getLeft() == null){
                node.setLeft(new TreeNode<>(value));
            } else {
                addHelper(node.getLeft(), value);
            }
        } else {    
            
            if (node.getRight() == null){
                node.setRight(new TreeNode<>(value));
            } else {
                addHelper (node.getRight(), value);
            }
        }   
    }
    
    @Override
    public boolean contains(T value) {
        
        return containsHelper(root, value);
    }
    
    private boolean containsHelper(TreeNode<T> node, T value){
        boolean result; 
        
        if (node == null){
            result = false;
        } else {
            
            if (value.compareTo(node.getValue()) < 0){
                
                result = containsHelper(node.getLeft(), value);
            } else 
                
                if (value.compareTo(node.getValue()) == 0){
                
                    result = true;
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
            
            TreeNode focusNode = root;
            TreeNode parent = root;
            
            boolean isItALeftChild = true;
            
            while (focusNode.getValue() != value){ 
                
                parent = focusNode;
                
                if (value.compareTo(focusNode.getValue()) < 0){
                    
                    isItALeftChild = true;
                    
                    focusNode = focusNode.getLeft();
                } else {
                    
                    isItALeftChild = false;
                    
                    focusNode = focusNode.getRight();
                }
                
                if (focusNode == null){
                    return false;
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
                    
                    TreeNode replacement = getReplacementNode(focusNode);
                    
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
    return true;            
} 
            
        
    
    private TreeNode getReplacementNode(TreeNode<T> replacedNode){
        
        TreeNode replacementParent = replacedNode;
        TreeNode replacement = replacedNode;
        
        TreeNode focusNode = replacedNode.getRight();
        
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
    public T removeAny() throws Exception {
        if (size == 0){
            throw new Exception ("The set is empty! Add some values first");
        }
        
        T value = root.getValue();
        
        remove(value);
        
        return value;
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
    
    private String toStringHelper(TreeNode<T> node){
        if (node == null){
            return"";
        }
        return toStringHelper(node.getLeft()) + " " +
                node.getValue() + " " + 
                toStringHelper(node.getRight())+ " ";
    }

}
