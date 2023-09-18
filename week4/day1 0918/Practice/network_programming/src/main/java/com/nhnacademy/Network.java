package com.nhnacademy;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Network {
    public static void main(String[] args) {
                try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("서버에 연결되었습니다.");
                
            socket.close();
            
        }catch(UnknownHostException r) {
            System.out.println(r);
        }      
        catch (IOException e) {
            System.err.println(e);
        }
    }
}
