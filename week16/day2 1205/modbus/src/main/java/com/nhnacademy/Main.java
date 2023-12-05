package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{

        try (Socket socket = new Socket("172.19.0.11", 502);
                BufferedOutputStream outputStream =
                        new BufferedOutputStream(socket.getOutputStream());
                BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());


        ) {
            byte[] request = {0, 1, 0, 0, 0, 6, 1, 3, 0, 0, 0, 5};
            outputStream.write(request);
            outputStream.flush();

            byte[] response = new byte[512];
            int receivedlength = inputStream.read(response, 0, response.length);

            System.out.println(Arrays.toString(Arrays.copyOfRange(response, 0, receivedlength)));


        } catch(UnknownHostException e){
            System.err.println("Unknown host!!");
        }

    }
}
