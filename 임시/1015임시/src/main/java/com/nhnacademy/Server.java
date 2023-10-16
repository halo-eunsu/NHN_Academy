package com.nhnacademy;

import com.nhnacademy.node.TCPServer;
import com.nhnacademy.wire.Wire;

public class Server {
    
    public static void main(String[] args) {
        
        //노드들 생성, intputWires와 outputWires 배열들의 길이는 해당 노드의 생성자에 직접 입력
        TCPServer server = new TCPServer("server");

        //연결할 Wire 만들기
        Wire wire1 = new Wire();

        //connet해주기


        //노드들 start();
        server.start();

    }
}
