package com.nhnacademy.app;
import java.util.Random;
import org.apache.commons.math3.random.RandomGenerator;


public class ApacheCommonsRandom {

    public static void main(String[] args) {
        
        Random r = new Random(0);
        

        for(int i = 0; i< 10; i++){
            int rand = r.nextInt(1000) + 1;
            System.out.println("random : " + rand);
        }
    }
}
