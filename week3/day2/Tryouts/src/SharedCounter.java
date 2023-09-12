public class SharedCounter implements Runnable {



    Thread thread;
    int count;
    int maxCount;
    SharedCount sharedCount;


    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        thread = new Thread(this, name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
    }


    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    public int getCount() {
        return count;
    }

    public Thread getThread() {
        return thread;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && (count < maxCount)) {
            count++;
            synchronized (sharedCount) {
                sharedCount.increment();
            }


        }

    }


    public static void main(String[] args) {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 10000, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 10000, sharedCount);

        counter1.start();
        counter2.start();

        while (counter1.isAlive() || counter2.isAlive()) {

        }

        System.out.println("counter1 : " + counter1.getCount());
        System.out.println("counter2 : " + counter2.getCount());
        System.out.println("sharedCount : " + sharedCount.getCount());

    }
}
