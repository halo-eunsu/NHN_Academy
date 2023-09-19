package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Quiz09 {
    


  public static void main(String[] args) {
    try(ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader terminalIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter terminalOut = new BufferedWriter(new OutputStreamWriter(System.out));
        
        ){
            System.out.println("접속에 성공하였습니다.");
            String line;

            while((line = socketIn.readLine()) != null){
                socketOut.write(line + "\n");
                socketOut.flush();

                line = terminalIn.readLine();
                System.out.println(line);
            }

    }catch(IOException ignore) {
        System.out.println("연결에 실패하였습니다.");
    }
       
    }

}
