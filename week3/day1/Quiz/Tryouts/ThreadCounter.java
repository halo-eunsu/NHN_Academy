package com.nhnacademy.thread_class_extension;

public class ThreadCounter extends Thread {
    int count;
    int maxCount;

    public ThreadCounter(String name, int maxCount) {
        setName(name);
        this.maxCount = maxCount;
        count = 0;
    }


}

class RunnerableCounter implements Runnable {

    int count = 0;
    String name;
    int maxCount;
    Thread thread;
    boolean running = false;

            public RunnerableCounter(String name, int maxCount) {
                this.name = name;
                this.maxCount = maxCount;
                this.thread = new Thread(this);

            }


    public void start() {
        thread.start();
    }


    public void stop(){
        running = false;
    }

    public boolean isRunning() {
        return running;
    }



    @Override
    public void run() {

        running = true;

        while (running && count < maxCount) {
            try {
                ++count;
                System.out.println(getName() + " : " + count);
                Thread.sleep(10000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

}


class Run{


    public static void main(String[] args) {
        
        ThreadCounter thread1 = new ThreadCounter("counter2", 10);
        ThreadCounter thread2 = new ThreadCounter("counter", 10);
        

        thread1.start();

        thread2.start();

        
    }
}