package com.nhnacademy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Channel {

    private final Queue<Request> queue;
    private final int queueMaxSize;



    public Channel(int queueSize) {
        this.queueMaxSize = queueSize;
        queue = new LinkedList<>();
        //queue = new LinkedBlockingDeque<>(queueSize);
    }

    public synchronized Request takeRequest(){
        return queue.poll();
    }
    
    public void addRequest(Request request){
        while (queue.size()>=queueMaxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("add queue", e);
                // TODO: handle exception
            }
        }
    }

}
