

public class AnswerQuiz01Teacher{

    public static void main(String[] args) {
        

        Counter counter = new Counter("counter", 5);


        counter.run();
    }


}



class Counter {
    String name;
    int count;
    int maxCount;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        count = 0;
    }

    public void run() {
        while (count < maxCount) {
            try {
                ++count;
                System.out.println(name + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}