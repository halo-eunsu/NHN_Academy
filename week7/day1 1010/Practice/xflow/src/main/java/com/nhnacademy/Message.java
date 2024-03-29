package com.nhnacademy;

public abstract class Message {

    static int count;
    String id;

    protected Message() { 
        this(String.valueOf(System.currentTimeMillis()) + (++count));
    }

    protected Message (String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
}
