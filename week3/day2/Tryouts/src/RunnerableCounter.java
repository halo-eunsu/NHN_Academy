

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

    public String getName() {
        return name;
    }

    public Thread getThread() {
        return thread;
    }

    public void start() {
        thread.start();
    }


    public void stop() {
        thread.interrupt();
    }

    public boolean isRunning() {
        return thread.isAlive();
    }



    @Override
    public void run() {

        thread = Thread.currentThread();
        try {
            while (!Thread.interrupted() && (count < maxCount)) {
                count++;
                System.out.println(getName() + " : " + count);
                Thread.sleep(10000);
            }
        } catch (InterruptedException ignore) {
            System.out.println(getName() + " interrupted.");
            Thread.currentThread().interrupt(); // 다시 인터럽트 상태를 설정
        }
        System.out.println(name + " finished.");
    }



    public static void main(String[] args) throws InterruptedException {
        RunnerableCounter thread1 = new RunnerableCounter("counter2", 10);
        RunnerableCounter thread2 = new RunnerableCounter("counter", 10);

        thread1.start();
        thread2.start();


        Thread.sleep(2000);
        thread1.stop();
    }

}
