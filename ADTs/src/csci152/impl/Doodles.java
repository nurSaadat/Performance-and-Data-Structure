package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Stack;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Sunny
 */
public class Doodles {
    
    public static void main (String [] args){
        
       lesson16();
        
    }
    
    public static void lesson22(){
        Map<Integer, String> testQ = new TreeMap();

        try {

            testQ.put(57, "Sara");
            testQ.put(12, "Riko");
            testQ.put(36, "Sher");
            testQ.put(45, "Fara");
            testQ.put(96, "Adilya");
            System.out.println("Size: " + testQ.size() + " || " + testQ.toString());


            testQ.remove(12);
            System.out.println("Size: " + testQ.size() + " || " + testQ.toString());

            testQ.remove(56);
            System.out.println("Size: " + testQ.size()+ " || " + testQ.toString());

            testQ.put(45, "Han");
            testQ.put(57, "Hyunjin");
            System.out.println("Size: " + testQ.size() + " || " + testQ.toString());

            testQ.put(64, "Buva");
            testQ.put(78, "Moma");
            testQ.put(28, "Appa");
            System.out.println("Size: " + testQ.size() + " || " + testQ.toString());

            testQ.clear();
            System.out.println("Size: " + testQ.size() + " || " + testQ.toString());

            testQ.put(16, "Danisa");
            testQ.put(78, "Appa");
            System.out.println("Size: " + testQ.size() + " || " + testQ.toString());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Size: " + testQ.size() + " || " + testQ.toString());
        }


    }
    
    public static void lesson16(){
       Set<Integer> set = new HashSet<>();
       
       set.add(5);
       set.add(12);
       set.add(3);
       set.add(6);
       set.add(14);
       set.add(2);
       set.add(-6);
       set.add(8);
       set.add(0);
       
       System.out.println("Size: " + set.size() + " // " 
               + set.toString());
       
       set.add(14);
       set.add(-6);
       set.add(5);
       
       System.out.println("Size: " + set.size() + " // " 
               + set.toString());
       
       System.out.println("Set contains 12: " + set.contains(12));
       System.out.println("Set contains 7: " + set.contains(7));
       System.out.println("Set contains 2: " + set.contains(2));
       System.out.println("Set contains -8: " + set.contains(-8));set.contains(-8);
       System.out.println("Set contains 5: " + set.contains(5));
       
       set.clear();
       System.out.println("Size: " + set.size() + " // " 
               + set.toString());
       
       set.add(55);
       set.add(24);
       set.add(78);
       set.add(51);
       
       System.out.println("Size: " + set.size() + " // " 
               + set.toString());
    }
    
    public static void printTree(TreeNode<Integer> node){
        
        if (node == null){
            return;
        }
        System.out.println(node.getValue() + "");
        printTree(node.getLeft());
        printTree(node.getRight());
    
    }
    
    public static void lesson6(){
         Stack<Integer> stk = new ArrayListStack();
        
        try{
//            stk.pop();
            
            for (int i = 0; i < 12; i++){
                stk.push(i);
            }
            System.out.println(stk);
            
            for (int i = 0; i < 7; i++){
                stk.pop();
            }
            System.out.println(stk);
            
            stk.clear();
            System.out.println(stk);
            
            for (int i = 0; i < 22; i++){
                stk.push(i);
            }
            System.out.println(stk);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static Stack<Integer> fibonacci(int n){
        
        Stack<Integer> stk = new LinkedListStack();
        int sum = 1, k = n, prev = 1;
        
        for(int i = 0; i < n; i++){
            
            if (n == k){
                
                stk.push(sum);
                stk.push(sum);
                sum = sum + prev;
                prev = sum;
                stk.push(sum);      
                k =-2;
                
            } else {
                
                sum = sum + prev;
                prev = sum;
                stk.push(sum);
                k --;
            }
        }
        return stk;
        
    }
    
    public static int oddCount(Queue<Integer> myQ){
        int sizeMyQ = myQ.getSize();
        int k, count = 0;
        
        for (int i = 0; i < sizeMyQ; i++){
            try {
                
            k = myQ.dequeue();
            myQ.enqueue(k);
            
            if (k % 2 == 1){
                count ++;
            }
            
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return count;
    }
    
}
