package com.nhnacademy.NodePractice;

public class Node {
    

    int id;
    String name;
    static int count;

    public int getTotalCount() {
        return count;
    }

    protected Node(){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    




}
