package com.nhnacademy;

public class CouponRequest extends Request{


    private final Customer customer;

    public CouponRequest(Customer customer) { 
        this.customer = customer;
    }


    @Override
    protected void execute(){
        // 쿠폰발급 로직

        if(CouponGenerator.getcouponGenerator().next()){
            log.info("thread=id:{}, custormer-id:{}, coupon-id:{}",Thread.currentThread().getId(), customer.getCouponli);


        }
        else{
            log.info("thread=id:{}, custormer-id:{}, coupon-id:{}",Thread.currentThread().getId(), customer.getCouponli);
        }
    }
    
}
