package com.nhnacademy;

import java.util.concurrent.atomic.AtomicLong;

public class Request {
    
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    private final long requestId;


    public Request(){
        this.requestId = ID_GENERATOR.incrementAndGet();

    }

    protected abstract void execute();


    public String toString() {
        return "requestId = " + requestId;
    }

    


}
