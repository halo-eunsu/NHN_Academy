


public class SharedCount {
    int count;

    public SharedCount() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increment() {
        count++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {
        }
    }



}
