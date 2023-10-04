package com.nhnacademy;

import java.io.*;
import java.net.Socket;


public class Example {
    
}



class HttpRequestWithSocket {
    public static void main(String[] args) {
        try {
            // 요청 헤더 및 URL 설정
            String host = "httpbin.org";
            String method = "GET";
            int port = 80;
            String path = "https://httpbin.org/get";
            String request = method + " " + path + " HTTP/1.1\r\n" +
                    "Host: " + host + "\r\n" +
                    "User-Agent: My Java App\r\n" +
                    "Connection: close\r\n\r\n";

            // 소켓 연결
            Socket socket = new Socket(host, port);

            // 요청 보내기
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(request.getBytes());
            outputStream.flush();

            // 응답 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            // 응답 출력
            System.out.println(response.toString());

            // 소켓 및 스트림 닫기
            outputStream.close();
            reader.close();
            socket.close();

        } catch (IOException e) {
           System.out.println("입력이 잘못되었습니다.\n");
        }
    }
}

