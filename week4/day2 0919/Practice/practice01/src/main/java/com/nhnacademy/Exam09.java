package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Exam09 {
    
    public static void main(String[] args) {
    try(Socket socket = new Socket("ems.nhnacademy.com", 12345);
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader terminalIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter terminalOut = new BufferedWriter(new OutputStreamWriter(System.out));
        ){

            String line;

            while((line = terminalIn.readLine()) != null){
                socketOut.write(line + "\n");
                socketOut.flush();

                line = socketIn.readLine();
                System.out.println(line);
            }

    }catch(IOException ignore) {
        System.out.println("연결에 실패하였습니다.");
    }
       
    }
 }

