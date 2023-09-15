package com.nhnacademy;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CouponGenerator {
    


    private static final int COUPON_MAX_SIZE = 50;

    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    private static final CouponGenerator CouponGenerator = new CouponGenerator();

    public static CouponGenerator getcouponGenerator(){
        return INTANCE;
    }

    @Override
    public synchronized boolean hasNext {
        return ID_GENERATOR.get() < COUPON_MAX_SIZE;
    }

    @Override
    public Coupon next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return Coupon
    }

}
