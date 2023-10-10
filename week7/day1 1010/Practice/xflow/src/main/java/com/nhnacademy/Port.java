package com.nhnacademy;

public class Port {
    static int count;
    String id;

    protected Port() {
        this(String.valueOf(System.currentTimeMillis()) + (++count));

    }

    protected Port(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }


}
