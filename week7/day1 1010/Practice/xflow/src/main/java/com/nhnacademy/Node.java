package com.nhnacademy;

public abstract class Node {
    
    String id;
    String name;

    
    


    //최소 protected private는 안됨
    protected Node(String id){
        //고유번호 생성
        this.id = String.valueOf(System.currentTimeMillis());
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
