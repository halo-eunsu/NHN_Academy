package com.nhnacademy;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class PCManagerSolution {
    private final LinkedList<Integer> buffer = new LinkedList<>();
    private final int bufferSize;

    public PCManager(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void produce() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.size() == bufferSize) {
                
                log.info("Buffer is full. Producer is waiting...");
                buffer.wait();
            }

            int data = generateData(); // 데이터를 생성하거나 가져옴 (예를 들어, 랜덤 숫자 생성)
            buffer.add(data); // 데이터를 버퍼에 추가
            log.info("생산자-데이터 생성: " + data);

            // 소비자에게 알림
            buffer.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                // 버퍼가 비어 있으면 소비자가 대기
                log.info("Buffer is empty. Consumer is waiting...");
                buffer.wait();
            }

            int data = buffer.remove(); // 버퍼에서 데이터 제거 및 소비
            log.info("소비자 소비: " + data);

            // 생산자에게 알림
            buffer.notifyAll();
        }
    }

    private int generateData() {
        // 데이터 생성 또는 가져오는 로직을 구현 (예: 랜덤 숫자 생성)
        return (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        PCManager pcManager = new PCManager(5); // 버퍼 용량을 5로 설정

        // 생산자 스레드 생성 및 실행
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pcManager.produce();
                    Thread.sleep(1000); // 생산자 스레드가 데이터를 생성하는 간격
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 소비자 스레드 생성 및 실행
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pcManager.consume();
                    Thread.sleep(1000); // 소비자 스레드가 데이터를 소비하는 간격
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    
}