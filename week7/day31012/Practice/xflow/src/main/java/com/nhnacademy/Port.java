package com.nhnacademy;

import java.util.PriorityQueue;
import java.util.Queue;
import org.apache.logging.log4j.core.net.Priority;

public class Port {
    static int count;
    String id;
    //T id // 타입 미정
    
    Queue<Message> queue;

    //PriorityQueue ;

    protected Port() {
        this(String.valueOf(System.currentTimeMillis()) + (++count));

    }

    protected Port(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void put(Message message){
        queue.add(message);
    }

    public Message peek() {
        return queue.peek();
    }

    public Message poll(){
        return queue.poll();
    }

}
