package com.nhnacademy;

import java.net.Socket;

public class Example01 {

    public static void main(String[] args) {
         
        try {
                Socket socket = new Socket("ems.nhnacademy.com",12345);

                System.out.println("서버에 연결되었습니다.");

                for( int i = 0; i < 10 ;i++){
                    socket.getOutputStream().write("Hello1234!".getBytes());

                }
                System.err.println("성공!");
                socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
