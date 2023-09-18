package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Quiz05 {

    
    public static void main(String[] args) {
        byte[] buffer = new byte[2048];
        try (Socket socket = new Socket("localhost", 12345);
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)
        ) {
           int length;
           while((length = bufferedInputStream.read(buffer)) >= 0){
            String line = new String(buffer, 0, length).trim();
            System.out.println("Read : " + line);
            //System.out.println("Read : " + new String(buffer, 0, length));
           }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
