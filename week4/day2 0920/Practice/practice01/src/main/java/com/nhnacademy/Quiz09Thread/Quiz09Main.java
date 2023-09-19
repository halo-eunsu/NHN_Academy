package com.nhnacademy.Quiz09Thread;

public class Quiz09Main {
    

    public static void main(String[] args) {
        
        Client client = new Client();

        Thread thread = new Thread(client);
        

    }
}
