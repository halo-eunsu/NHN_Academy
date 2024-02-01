package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.Main;
import com.nhnacademy.edu.springframework.User;

public class SmsMessageSender implements  MessageSender{
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("SMS Message Sent to ${phoneNumber} : ${message}");
    }
}
