package com.nhnacademy.edu.springframework.practice.practice02;

import com.nhnacademy.edu.springframework.MessageSender.MessageSender;
import com.nhnacademy.edu.springframework.MessageSender.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    public static void main(String[] args) {


        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSender sendEmailMessage = context.getBean("sendEmailMessage", MessageSender.class);
            MessageSender sendSmsMessage = context.getBean("sendSmsMessage", MessageSender.class);

            sendEmailMessage.sendMessage(new User(), "hi");

        }
    }
}


