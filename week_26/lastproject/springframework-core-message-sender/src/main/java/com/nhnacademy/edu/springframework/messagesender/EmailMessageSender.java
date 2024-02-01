package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.User;

public class EmailMessageSender implements  MessageSender{
    @Override
    public void sendMessage(User user, String message) {
        System.out.println("Email Message Sent ${email} : ${message}");
    }
}
