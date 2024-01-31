package com.nhnacademy.edu.springframework;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        User user = new User("dsfsf@nhn.com","000-1111-2222");
        System.out.println("Hello world!");
        main.sendEmailMessage(user, "message");
    }



    private void sendEmailMessage(User user, String message){
        System.out.println("SMS Message Sent to ${phoneNumber} : ${message}");
    }

    private void sendSMSMessage(User user, String message){
        System.out.println("Email Message Sent ${email} : ${message}");
    }




}


