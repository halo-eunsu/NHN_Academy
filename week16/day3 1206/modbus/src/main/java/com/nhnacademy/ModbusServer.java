package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ModbusServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(11502)) {

            int[] holdingRegisters = new int[100];
            // for ( int i = 0;i<holdingRegisters)

            Socket socket = serverSocket.accept();
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());

            while (socket.isConnected()) {
                byte[] inputBuffer = new byte[1024];

                int receivedlength = inputStream.read(inputBuffer, 0, inputBuffer.length);

                if(receivedlength > 0){
                    System.out.println(Arrays.toString(Arrays.copyOfRange(inputBuffer, 0, receivedlength)));
                    

                    if((receivedlength > 7) && (6 + inputBuffer[5]) == receivedlength){
                        if(unitId == inputBuffer[6]){
                            int transactionId = (inputBuffer[0] << 8)   |   inputBuffer[1];
                            int functionCode = inputBuffer[7];

                            switch (functionCode){
                            
                            
                            case 3:
                                int address = inputBuffer[8] << 8 | inputBuffer[9];
                                int quantity = inputBuffer[10] << 8 | inputBuffer[11];


                                if(address + quantity < holdingRegisters.length){
                                    System.out.println("Address : " + address + ", Quantity : " + quantity);
                                    //ByteBuffer buffer = ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN);
                                    //buffer.put(inputBuffer, 8, 2);

                                // int quantity = buffer. getInt();
                                     outputStream.write(SimpleMB.addMBAP(transactionId, unitId, SimpleMB.makeReadHoldingRegisterRequest(address, Arrays.copyOfRange(holdingRegisters, 0, quantity))););
                                Arrays.copyOfRange(holdingRegisters, 0,quantity);
                                outputStream.flush();

                                
                                
                                byte[] buffer = new byte[quantity * 2];
                                for(int i = 0;i<quantity; i++){
                                    buffer[i*2] = (holdingRegisters[address + i] >> 8 & 0xFF);
                                }
                                
                                }
                                
                               
                                
                                break;
                        
                            default:
                                break;
                            }
                        }
                    } 
                    if((6 + inputBuffer[5]) != receivedlength){
                        System.err.println("수신 패킷 길이가 잘못되었습니다.");
                    
                    }else{
                        
                        switch (inputBuffer[7]) {
                            case 3:
                                int address = inputBuffer[8] << 8 | inputBuffer[9];
                                int quantity = inputBuffer[10] << 8 | inputBuffer[11];


                                if(address + quantity < holdingRegisters.length){
                                    ByteBuffer buffer = ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN);
                                buffer.put(inputBuffer, 8, 2);

                                // int quantity = buffer. getInt();

                                System.out.println("Address : " + address + ", Quantity : " + quantity);
                                
                                byte[] buffer = new byte[quantity * 2];
                                for(int i = 0;i<quantity; i++){
                                    buffer[i*2] = (holdingRegisters[address + i] >> 8 & 0xFF);
                                }
                                
                                }
                                
                                outputStream.write(SimpleMB.addMBAP(transactionId, unitId, SimpleMB.makeReadHoldingRegisterRequest(address, Arrays.copyOfRange(holdingRegisters, 0, quantity))););
                                Arrays.copyOfRange(holdingRegisters, 0,quantity);
                                outputStream.flush();

                                
                                break;
                        
                            default:
                                break;
                        }
                    }
                }
                else if(receivedlength < 0){
                    break;
                }
                
            }

            

        } catch (Exception e) {
            System.err.println(e.getMessage());
            // TODO: handle exception
        }
    }
}
