package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Quiz07 {

    static class Receiver implements Runnable {

        public Receiver(BufferedInputStream inputStream){

        }

        public void run(){




            try {
                byte [] buffer = new byte[2048];
                int length;

                while ((length = inputStream.read(buffer)) >= 0){

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    
    public static void main(String[] args) {
        byte[] buffer = new byte[2048];
        try (Socket socket = new Socket("ems.nhnacademy.com", 12345);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            Receiver receiver = new Receiver(inputStream);
            Thread receiverThread = new Thread(receiver);
            receiverThread.start();

        ) {
           
           String line;

           while((line = reader.readLine()) != null) {

            outputStream.write(line.getBytes());
            outputStream.flush();
            
            int length = inputStream.read(buffer);
            System.out.println(new String(buffer, 0, length));
           }
           
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
