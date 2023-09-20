package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Exam10 {
    
    public static void main(String[] args) {
        
        
        String host = "localhost";
        int port = 12345;

        

        try {
            Socket socket = new Socket(host, port);
            System.out.println("연결에 성공했습니다.");

            int readlength;
            BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
            

            byte[] buffer = new byte[2048];

            while((readlength = inputStream.read(buffer))>0){
                if(new String(buffer, 0, readlength).trim().equals("exit")){
                    break;
                }
                outputStream.write(buffer, port, readlength);
            }

            socket.close();




        } catch (IOException e) {
            System.out.println("접속에 실패했습니다.");
        }
        
    


    }
}
