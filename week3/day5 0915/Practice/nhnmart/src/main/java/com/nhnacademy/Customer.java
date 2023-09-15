package com.nhnacademy;

public class Customer {
    
    private final long id;
    private final String name;
    private int money;




    public Customer(int id, String name, int money){

        this.id = id;
        this.name = name;
        this.mone = money;




    }


    public static Customer (long id, String name){

        return new Customer(id, name, 1000000);
        
    }









}
