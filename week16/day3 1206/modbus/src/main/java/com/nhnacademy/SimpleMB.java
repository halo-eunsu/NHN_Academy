package com.nhnacademy;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimpleMB {
    
    
    
    
    public static byte[] makeReadHoldingRegisterRequest(int address, int quantitiy){

        byte[] frame = new byte[5];

        ByteBuffer b = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);

        //function code
        frame[0] =  0x03;
        


        //data
        b.putInt(address);
        frame[1] =  b.get(2);
        frame[2] =  b.get(3);

        b.clear();
        b.putInt(quantitiy);
        frame[3] =  b.get(2);
        frame[4] =  b.get(3);

        return frame;
        
    }

    public static byte[] makeReadHoldingRegisterRequest(int address, int[] registers) { 
        byte[] frame = new byte[1 + 1 + registers.length * 2];


        //PDU의 funciton Code 
        frame[0] = 0x03;

        // length
        frame[1] = (byte) (registers.length * 2);

        for(int i = 0; i < registers.length; i++){
            frame[ 2 + i * 2] = (byte) registers[i]
        }

    }

    public static byte[] addMBAP(int transactionId, int unitId, byte[] pdu){

        byte[] adu = new byte[7 + pdu.length];
        ByteBuffer b = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);

        b.putInt(transactionId);


        // byte로 casting 한 adu
        adu[0] = b.get(2);
        adu[1] = b.get(3);
        adu[2] = 0;
        adu[3] = 0;
        adu[4] = 0;
        adu[5] = (byte) (pdu.length + 1);
        adu[6] = (byte) unitId;
        System.arraycopy(pdu, 0, adu, 7, pdu.length);

        return adu;



    }
}
