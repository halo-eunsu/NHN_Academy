package com.nhnacademy;

import java.io.*;
import java.net.Socket;
import org.apache.commons.cli.*;

public class CustomHttpClient {

    public static void main(String[] args) {
        Options options = new Options();

        // 사용자 정의 헤더 옵션 추가
        Option customHeaderOption = Option.builder("X")
                .longOpt("header")
                .argName("header")
                .hasArgs()
                .desc("사용자 정의 헤더를 추가합니다.")
                .build();

        options.addOption(customHeaderOption);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            // 명령줄에서 사용자 정의 헤더를 가져옴
            String[] customHeaders = cmd.getOptionValues("X");

            // HTTP GET 요청 생성 및 사용자 정의 헤더 추가
            String host = "httpbin.org";
            int port = 80;

            try (Socket socket = new Socket(host, port)) {
                // HTTP 요청 문자열 생성
                String request = "GET /get HTTP/1.1\r\n" +
                                 "Host: " + host + "\r\n" +
                                 "User-Agent: CustomHttpClient\r\n";
       `          
                if (customHeaders != null) {
                    for (String header : customHeaders) {
                        request += header + "\r\n";
                    }
                }
                
                request += "\r\n";  // 요청 끝을 나타내는 빈 줄 추가

                // HTTP 요청 전송
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(request.getBytes());
                outputStream.flush();

                // 응답 읽기
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (ParseException | IOException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
}
