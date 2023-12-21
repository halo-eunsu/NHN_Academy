package com.nhnacademy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class 참고자료 {
    public static void main(String[] args) {
        byte unitID = 1;
        int[] holdingRegisters = new int[100];

        for (int i = 0; i < holdingRegisters.length; i++) {
            holdingRegisters[i] = i;
        }

        try (ServerSocket serverSocket = new ServerSocket(11502)) {
            Socket socket = serverSocket.accept();  // 따로 빼서 try 사용하고 thread로 동작하도록 해줘야 함
            BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());

            while (socket.isConnected()) {  //disconnect > -1 / handler thread 종료  //하나라도 안들어오면 죽어서 모두 체크 필요
                byte[] inputBuffer = new byte[1024];

                int receivedLength = inputStream.read(inputBuffer, 0, inputBuffer.length);

                if (receivedLength > 0) {
                    System.out.println(
                            Arrays.toString(Arrays.copyOfRange(inputBuffer, 0, receivedLength)));

                    // 앞 6개 + 1개 (7개)
                    if ((receivedLength > 7) && (6 + inputBuffer[5]) != receivedLength) {  //packet 길이로 잘 왔는지 검증 가능(5번)
                        if (unitID == inputBuffer[6]) {  //serial의 경우 확인
                            int transactionId = (inputBuffer[0] << 8) | inputBuffer[1];  //반환시 필요 (받았을 땐 검증 필요X)
                            int functionCode = inputBuffer[7];  //PDU_OFFSET + 1 // packet recieve parsing이 젤 좋은 방법

                            switch (inputBuffer[7]) {   //functionCode lambda로 callback 가능하게
                                case 3: // HodingRegister  //FC_READ_HOLDING_REGITSERS_3
                                    int address = (inputBuffer[8] << 8) | inputBuffer[9];  //parameter  big_endian > 바꿈
                                    int quantity = (inputBuffer[10] << 8) | inputBuffer[11];  //parameter  big_endian > 바꿈

                                    if (address + quantity < holdingRegisters.length) {  //범위 내에 있는지 확인
                                        System.out.println("Address : " + address + ", Quantity : "
                                                + quantity);

                                        byte[] buffer = new byte[quantity * 2];

                                        for (int i = 0; i < quantity; i++) {
                                            buffer[i * 2] =
                                                    (byte) ((holdingRegisters[address + i] >> 8)
                                                            & 0xFF); // 상위바이트 먼저 넣어주기
                                            buffer[i * 2 + 1] =
                                                    (byte) (holdingRegisters[address + i] & 0xFF); // 하위바이트
                                                                                                   // 먼저
                                                                                                   // 넣어주기
                                        }

                                        //확인 끝나면 데이터 주기  //serial checksum 붙여주면 됨 (addMBAP 대신)
                                        outputStream.write(SimpleMB.addMBAP(transactionId, unitID,
                                                SimpleMB.makeReadHoldingRegistersResponse(address,
                                                        Arrays.copyOfRange(holdingRegisters, address,
                                                                quantity))));
                                        outputStream.flush();
                                    }
                                    break;

                                default:
                            }
                        
                        }

                    } else {
                            System.out.println("패킷 수신이 잘못되었습니다.");
                        }  
                    else if (receivedLength < 0) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}