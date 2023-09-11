



public class RunnerableCounter02 extends Thread {
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

    public String getName() {
        return name;
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
            thread = Thread.currentThread();
            try {
                while (!Thread.interrupted() && (count < maxCount)) {
                    count++;
                    System.out.println(getName() + " : " + count);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ignore) {
                System.out.println(getName() + " interrupted.");
                Thread.currentThread().interrupt(); // 다시 인터럽트 상태를 설정
            }
            System.out.println(name + " finished.");
        }


}


class Run{


public static void main(String[] args) {
    RunnerableCounter thread1 = new RunnerableCounter("counter2", 10);
    RunnerableCounter thread2 = new RunnerableCounter("counter", 10);

    thread1.start();
    thread2.start();

    
        Thread.sleep(2000);
    thread1.stop();
}

}