package org.eit;

public class Counter {

    private int data;
 
 
    public Counter(){
        data = 0;
    }
 
    public int increment(){
        data += 1;
        return data;
    }   
    
    public int decrement(){
        data -= 1;
        return data;
    }
    
    public int getCounter(){
        return data;
    }
}

