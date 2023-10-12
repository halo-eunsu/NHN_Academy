package com.nhnacademy.NodePractice;

public class Node {
    

    int id;
    int name;
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

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
    




}
