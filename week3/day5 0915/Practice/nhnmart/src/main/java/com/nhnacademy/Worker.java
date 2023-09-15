package com.nhnacademy;

public class Worker implements Runnable{
    

    private final Channel channel;

    private final Employee employee;

    public Worker(Channel channel, Employee employee){
        this.channel = channel;
        this.employee = employee;
    }

    public void run(){
        while(true){
            Request request = channel.takeRequest();
            request.execute(); //실행하면 끝나요
            log.info("직원 :{}이 쿠폰을 발급했습니다. ",employee.getName())
        }
    }


}
