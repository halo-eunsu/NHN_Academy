package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam051 {
    
    
    public static void main(String[] args) {
        int port = 1234;
            
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket;

            while ((socket = serverSocket.accept()) != null) {

                System.out.println(socket.getInetAddress().getHostAddress());
                socket.getOutputStream().write("Hello!".getBytes());
                socket.getOutputStream().flush();
                
            }
        }catch(IOException e)   {
            System.out.println(e);
        }

    }

}
