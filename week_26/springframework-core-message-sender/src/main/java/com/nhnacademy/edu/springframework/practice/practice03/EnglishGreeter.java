package com.nhnacademy.edu.springframework.practice.practice03;

public class EnglishGreeter implements Greeter {

    public void EnglishGreeter() {
        System.out.println("EnglishGreeter initiated!!");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
