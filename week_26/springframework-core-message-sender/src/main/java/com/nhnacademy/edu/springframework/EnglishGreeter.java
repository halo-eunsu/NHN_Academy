package com.nhnacademy.edu.springframework;

public class EnglishGreeter implements Greeter {

    @Override
    public boolean sayHello() {
        System.out.println("Hello World!");
        return true;
    }
}