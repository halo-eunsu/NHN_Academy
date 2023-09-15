package com.nhnacademy;

import java.lang.System.Logger;

public class Client extends Thread{
    private final Channel channel;


    public Client(Channel channel){
        this.channel = channel;
    }

    @Override
    public void run(){
        while (true){
            Customer customer = CustomerGenerator.getCustomerGenerator().next();
            Request request = new CouponRequest(customer);
            channel.addRequest(request);

            try {
                Thread.sleep(100);    
            } catch (Exception e) {
                Logger.error("",e);
            }
            
        }
    }
}

