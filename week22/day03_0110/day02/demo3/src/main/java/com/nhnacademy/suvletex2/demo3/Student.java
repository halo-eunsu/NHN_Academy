package com.nhnacademy.suvletex2.demo3;
import java.time.LocalDateTime;

public class Student {
    //아이디
    private  String id;
    //이름
    private  String name;
    //성별
    private  Gender gender;
    //나이
    private  int age;
    //생성일
    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ... java beans 특징을 고려하여 작성합니다.
}