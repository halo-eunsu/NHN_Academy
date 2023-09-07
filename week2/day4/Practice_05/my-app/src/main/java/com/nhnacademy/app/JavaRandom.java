package com.nhnacademy.app;
import java.util.Random;

public class JavaRandom {
    public static void main(String[] args) {
        
        Random r = new Random(0);
        for(int i = 0; i<10; i++){
            int rand = r.nextInt(100) + 1;
            System.out.println("java random: " + rand);
        }
    }
}
