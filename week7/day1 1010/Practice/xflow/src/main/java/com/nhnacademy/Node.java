package com.nhnacademy;

public abstract class Node {
    String id;
    String name;

    //최소 protected private는 안됨
    protected Node(String id){
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    
}
