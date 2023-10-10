package com.nhnacademy;

public abstract class Node {
    String id;


    //최소 protected private는 안됨
    protected Node(String id){
        this.id = id;
    }


    public String getId() {
        return id;
    }





    
}
