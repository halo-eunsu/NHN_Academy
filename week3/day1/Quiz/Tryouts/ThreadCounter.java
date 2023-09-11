package com.nhnacademy.thread_class_extension;

public class ThreadCounter extends Thread {
    int count;
    int maxCount;

    public ThreadCounter(String name, int maxCount) {
        setName(name);
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                ++count;
                System.out.println(getName() + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class RunnerableCounter implements Runnable {

    int count = 0;
    String name;
    int maxCount;
        Thread thread;

            public RunnerableCounter(String name, int maxCount) {
                this.name = name;
                this.maxCount = maxCount;
                this.thread = new Thread(this);

            }


    public void start() {
        thread.start();
    }

    @Override

}


class Run{


    public static void main(String[] args) {
        
        ThreadCounter thread1 = new ThreadCounter("counter2", 10);
        ThreadCounter thread2 = new ThreadCounter("counter", 10);
        

        thread1.start();

        thread2.start();

    }
}