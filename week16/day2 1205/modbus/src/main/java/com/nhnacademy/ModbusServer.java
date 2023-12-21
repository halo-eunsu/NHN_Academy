package com.nhnacademy;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ModbusServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(11502)) {

            Socket socket = serverSocket.accept();
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());

            while (socket.isConnected()) {
                byte[] inputBuffer = new byte[1024];

                int receivedlength = inputStream.read(inputBuffer, 0, inputBuffer.length);

                System.out.println(Arrays.toString(Arrays.copyOfRange(inputBuffer, 0, receivedlength)));
            }

            

        } catch (Exception e) {
            System.err.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
