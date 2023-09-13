package com.nhnacademy;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Node {
    static Integer count;
    final String id;
    Logger log;

    public Node( ) {
        
        count++;
        this.id = String.format("%s=%02d", getClass().getSimpleName(), count);
        log.trace("create node : {}", id);
    } // 기본 생성자
    
    public String getId() {
        return id;
    }
    
    
    //getter & setter
}