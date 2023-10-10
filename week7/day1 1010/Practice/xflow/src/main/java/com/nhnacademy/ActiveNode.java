package com.nhnacademy;

public class ActiveNode extends Node implements Runnable {

    Thread thread;

    protected ActiveNode() {
        super();
    }

    protected ActiveNode(String id) {
        super(id);
    }



    // run 구조
    protected void preprocess() {
        
    }

    public void start(){
        thread = new Thread(this);
        thread.start();
    }

    protected void postprocess() {

    }

    protected void mainp(){

    }

    //살아있는 동안 도세요...
    public boolean isAlive(){
        return !thread.isInterrupted();
    }


    //run 구조 : 교재의 'ActiveNode class는 아래와 같은 상태를 가질 수 있다.'  부분 그림
    @Override
    public void run() {
        
        preprocess();
        while(isAlive()){
            main();
        }
        postprocess();
    }
}
