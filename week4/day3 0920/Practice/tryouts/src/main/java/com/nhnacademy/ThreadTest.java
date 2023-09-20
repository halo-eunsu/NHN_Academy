package com.nhnacademy;

public class ThreadTest extends Thread{
    

    int id;
    String name;
    

    public ThreadTest(int id, String name){

        this.id = id;
        this.name = name;
    }

    public void run(){
        int counter = 0;
        
        for (int i = 0; i<100 ;i++){
            counter++;
            System.out.println(counter+name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        
    }

    public static void main(String[] args) {
        ThreadTest counter1 = new ThreadTest(1, "a");
        ThreadTest counter2 = new ThreadTest(2, "ab");


        counter1.start();
        counter2.start();
    }
}
