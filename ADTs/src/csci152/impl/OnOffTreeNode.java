package csci152.impl;

/**
 *
 * @author Sunny
 */
public class OnOffTreeNode<T> {
    
    private T value;
    
    private OnOffTreeNode<T> left;
    private OnOffTreeNode<T> right;
    private boolean active;
    
    /**
     * Construct a tree node with the given value,
     * and null children links.
     * 
     * @param val to set on the node
     */
    public OnOffTreeNode(T val) {
            value = val;
            left = null;
            right = null;
            active = true;
               
    }
    
        
    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }
    
    /**     * 
     * @return the left
     */
    public OnOffTreeNode<T> getLeft(){
        return left;
    }
    
    /**
     * @return the right
     */
    public OnOffTreeNode<T> getRight(){
        return right;
    }
    
    /**
     * @param left the left to set
     */
    public void setLeft(OnOffTreeNode<T> left){
        this.left = left;
    }
    
    /**
     * @param right the right to set
     */
    public void setRight(OnOffTreeNode<T> right){
        this.right = right;
    }
    
    /**
     * @return the string representation of the value
     */
    @Override
    public String toString(){
        return value.toString();
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    
}
