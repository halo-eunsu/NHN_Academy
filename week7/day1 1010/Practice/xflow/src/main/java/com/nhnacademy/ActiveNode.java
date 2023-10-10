package com.nhnacademy;

public class ActiveNode extends Node implements Runnable {

    Thread thread;
    int interval = 1;
    boolean stopped = true;

    protected ActiveNode() {
        super();
        thread = new Thread(this);
    }

    protected ActiveNode(String id) {
        super(id);
    }

    //setter getter 추가
    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }




    // run 구조
    protected void preprocess() {

    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop(){
        
        stopped = true;
        thread.interrupt();

    }
    //맞는가?

    protected void postprocess() {

    }

    protected void main() {

    }

    // 살아있는 동안 도세요...
    public boolean isAlive() {
        //return !thread.isInterrupted();
        return !stopped;
    }


    // run 구조 : 교재의 'ActiveNode class는 아래와 같은 상태를 가질 수 있다.' 부분 그림
    @Override
    public void run() {

        preprocess();
        while (isAlive()) {
            try {
                main();
                Thread.sleep(interval);
            } catch (Exception e) {
                //Thread.currentThread().interrupt();
                stop();
            }

        }
        postprocess();
    }
}
