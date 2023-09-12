package main.java.com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    Store store;
    Thread thread;
    long minWaitingTime = 10000;
    long maxWaitingTime = 30000;
    public Consumer(String name, Store store){
        thread = new Thread(this, name);
        this.store = store;
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                store.enter();

                store.buy();

                store.exit();

                long waitingTime = minWaitingTime +ThreadLocalRandom.current().nextLong(maxWaitingTime - minWaitingTime + 1);
                Thread.sleep(waitingTime);

            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
