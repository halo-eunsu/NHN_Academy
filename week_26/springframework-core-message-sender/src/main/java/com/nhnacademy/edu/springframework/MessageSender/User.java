package com.nhnacademy.edu.springframework.MessageSender;

public class User {

    private  String email;
    private  String phoneNumber;



    public  User(){};

    public  User(String email, String phoneNumber){

        this.email = email;
        this.phoneNumber =phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
