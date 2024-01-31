package com.nhnacademy.edu.springframework.practice.practice04;

public class EnglishGreeter implements Greeter {

    public void EnglishGreeter() {
        System.out.println("EnglishGreeter initiated!!");
    }

    public void afterPropertiesSet() {
        // do some initialization work
    }

    public void init() {
        System.out.println("EnglishGreeter init called!!");
    }


    public void destroy() {
        // do some destruction work (like releasing pooled connections)
        System.out.println("destroy method called in EmailMessageSender");

    }

    public void cleanup() {
        System.out.println("EnglishGreeter cleanup called!!");
    }


    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
