package com.nhnacademy;

public class CouponRequest extends Request{


    private final Customer customer;

    public CouponRequest(Customer customer) { //쿠폰을 발급하기 위해 고객이 줄을 서면, 
        this.customer = customer;
    }


    @Override
    protected void execute(){
        // 쿠폰발급 로직
    }
    
}
