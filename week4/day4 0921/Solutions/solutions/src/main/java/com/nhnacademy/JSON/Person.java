package com.nhnacademy.JSON;

public class Person {
    String name;

    Address address;

    public Person(String name, Address address){

        this.name = name;
        this.address= address;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Address getAddress(){
        return address;
    }

    // public Address getAddress2(){
    //     return address;
    // }
}
