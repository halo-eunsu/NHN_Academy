package com.nhnacademy;

public class Coupon {
    


    private final long id;
    private final int amount;
    private final CouponType couponType;


    private Coupon(long id, int amount, CouponType couponType){
        this.id = id;
        this.amount = amount;
        this.couponType = couponType;
    }

    public static Coupon ofDisCount(long id, int amount ) { return new Coupon(id, amount ,CouponType.DISCOUNT);}
    
    
    public static Coupon percentDisCount(long id, int amount ) { return new Coupon(id, amount ,CouponType.PERCENT);}

    public long getId(){return id; }

    public int amount() { return amount();}


    public CouponType getCouponType() { return couponType; }

    enum CouponType {


        DISCOUNT,
        PERCENT


    }
}
