package main.java.com.nhnacademy;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Thread thread;
    Store store;
    int minWaitingTime = 1000;
    int maxWaitingTime = 5000;

    public Producer(Store store) {
        thread = new Thread(this, "producer");
        this.store = store;
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                long waitingTime = minWaitingTime +ThreadLocalRandom.current().nextInt(maxWaitingTime - minWaitingTime + 1);
                Thread.sleep(waitingTime);

                if (store == null) {
                    System.out.println(thread.getName() +" :" +(new Date()) +" : " + waitingTime);
                } else {
                    store.sell();
                }

            } catch(NotEnoughBoxException ignore){
                System.out.println("재납품을 준비합니다.");
            } catch(InterruptedException ignore){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer(null);

        producer.start();
    }
}
