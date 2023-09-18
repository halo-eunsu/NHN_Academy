package com.nhnacademy;

import java.net.Socket;
import org.slf4j.Logger;
import lombok.extern.slf4j.Slf4j;



@Slf4j
public class Quiz03 {
   
    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("ems.nhnacademy.com", 12345);
            log.info("localaddress : {}", socket.getLocalAddress());    
            log.info("local Port : {}", socket.getLocalPort());    

        } catch (Exception e) {
          System.out.println("서버 연결 실패");
        }
        
        
    }
}


