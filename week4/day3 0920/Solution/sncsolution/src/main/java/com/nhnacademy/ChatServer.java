//BroadCast EchoServer


package com.nhnacademy ;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ChatServer extends Thread {
    static List<ChatServer> serverList = new LinkedList<>();
    Socket socket;
    BufferedWriter writer;


    public ChatServer(Socket socket) {

        this.socket = socket;
        serverList.add(this);
    }


    public void send(String message) throws IOException {
        writer.write(message);
        writer.flush();
    }



    @Override
    public void run(){


        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             )
        {
            this.writer = writer;
            while(!Thread.currentThread().isInterrupted()) {
                String line = reader.readLine();
                //id 확인
                String[] tokens = line.trim().split(":");
                if(tokens.length > 1) {
                    if(tokens[0].equalsIgnoreCase("ID")){
                        setName(tokens[1]);
                    }
                }


                for(ChatServer server : serverList) {
                    server.send(line);
                }
            }
        } catch (IOException ignore) {
            
        }
        try {
            socket.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        int port = 1234;

        List<ChatServer> serverList = new LinkedList<>();


        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            while(!Thread.currentThread().isInterrupted()){
                Socket socket = serverSocket.accept();

                ChatServer server = new ChatServer(socket);
                server.start();


                serverList.add(server);
            }
        }catch(IOException e){

        }

        for(ChatServer server : serverList){
            server.interrupt();
            try {
                server.join();
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
