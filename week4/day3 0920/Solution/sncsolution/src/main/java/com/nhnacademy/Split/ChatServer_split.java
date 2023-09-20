package com.nhnacademy.Split;

import java.util.Arrays;

public class ChatServer_split {
    
    public static void main(String[] args) {
        String [] tokens = "#A:@B:Hello!".trim().split(":");    

        //trim : 공백 자르기
        //split("a") : a를 기준으로 문자열 자르기

        System.out.println(Arrays.toString(tokens));
    }
    
}
