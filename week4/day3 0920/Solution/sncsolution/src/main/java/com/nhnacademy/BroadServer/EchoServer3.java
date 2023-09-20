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

public class EchoServer3 extends Thread {
    static List<EchoServer3> serverList = new LinkedList<>();
    Socket socket;
    BufferedWriter writer;


    public EchoServer3(Socket socket) {

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
                String line = reader.readLine() + "\n";
                for(EchoServer3 server : serverList) {
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

        List<EchoServer3> serverList = new LinkedList<>();


        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            while(!Thread.currentThread().isInterrupted()){
                Socket socket = serverSocket.accept();

                EchoServer3 server = new EchoServer3(socket);
                server.start();


                serverList.add(server);
            }
        }catch(IOException e){

        }

        for(EchoServer3 server : serverList){
            server.interrupt();
            try {
                server.join();
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
