/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152;

/**
 *
 * @author Sunny
 */
public class Student implements Comparable{
    
    private String firstName;
    private int id;
    private int year;
    
    public Student(String fName, int sid){
        firstName = fName;
        id = sid;
        year = 1;
    }
            
    public void incrementOneYear(){
        year++;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getId(){
        return id;
    }
    
    @Override
    public String toString(){
        return "< " + firstName + " ID: " + id + " >";
    }

    @Override
    public boolean equals(Object o) {
        
        if (o instanceof Student){
            Student stobj = (Student) o;
            return id == stobj.id && firstName.equals(stobj.firstName); 
        }
        
        return false;
    }    

    @Override
    public int compareTo(Object o) {
        Student stobj = (Student) o;
        
        if (id < stobj.getId()){
            return -1;
        } else if (id == stobj.getId()){
            return 0;
        } else {
            return 1;
        }
        
    }
}

