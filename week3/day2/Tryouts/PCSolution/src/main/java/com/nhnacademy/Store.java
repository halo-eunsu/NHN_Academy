package main.java.com.nhnacademy;

import java.util.concurrent.Semaphore;

public class Store {
    Semaphore box;
    Semaphore things;

    public Store(int boxCount) {
        box = new Semaphore(boxCount);
        things = new Semaphore(0);
    }

    public void enter() {
        System.out.println("소비자가 입장합니다.");
    }

    public void exit() {
        System.out.println("소비자가 퇴장합니다.");
    }

    public synchronized void buy() throws InterruptedException {
        System.out.println("소비자가 물건을 구매합니다.");
        while (!things.tryAcquire()) {
            wait();
        }
        box.release();
        System.out.println("소비자가 물건을 구매 했습니.[Box = " + box.availablePermits() + "]");
        notifyAll();
    }



    /*
     * Producer가 물건을 납품합니다.
     */
    public synchronized void sell() throws InterruptedException, NotEnoughBoxException {
        System.out.println("판매자가 입장하였습니다");
        if (!box.tryAcquire()) {
            throw new NotEnoughBoxException();
        }

        things.release();
        System.out.println("판매자가 물건을 납품 하였습니다.[Box = " + box.availablePermits() + "]");
        notifyAll();
    }
}
