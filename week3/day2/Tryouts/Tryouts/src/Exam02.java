

public class Exam02 {
    public static void main(String[] args) {
        RunnerableCounter runnableCounter = new RunnerableCounter("counter", 5);

        runnableCounter.start();
        System.out.println(runnableCounter.getThread().getState());
    }
}
