
package com.nhnacademy;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Timer;

@Slf4j
public class PCManager {
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int bufferSize;
    private final int bufferMaxSize;

    public PCManager(int bufferSize) {
        this.bufferSize = bufferSize;
    }
    public void produce() throws InterruptedException {
        int data = 0;

        while(true){
            synchronized (this){

                while(buffer.size() == bufferMaxSize){
                    wait();
                }

            }

            buffer.add(++data);
            log.info("생산자 - 데이터 생성 : {}", data);
            notifyAll();

            Thread.sleep(500);
        }
        //todo 생산자 구현
    }

    public void consume() throws InterruptedException {
       //todo 소비자 구현


        while(true){
            synchronized (this){

                while(buffer.size() == 0){
                    wait();
                }

            }
            int data = buffer.removeFirst();
            log.info("생산자 - 데이터 생성 : {}", data);
            notifyAll();

            Thread.sleep(500);
        }
    }
}

class Test01{


    public static void main(String[] args) {
        final PCManagerSolution pcManagerSolution = new PCManagerSolution(2);

        Thread s1 = new Thread() {
            @Override
            public void run(){

                try{
                    pcManagerSolution.produce();
                }catch (InterruptedException e){
                    ("InterruptedException", e);
                }
            }
        }





    }
}