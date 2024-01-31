package com.nhnacademy.edu.springframework;

public class KoreanGreeter implements Greeter {

    @Override
    public boolean sayHello() {
        // biz logic
        System.out.println("안녕 세상! ");
        return true;
    }
}