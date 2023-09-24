package com.nhnacademy;

import java.lang.module.ModuleDescriptor.Builder;

public class Guitarist {

    private int no;
    private String name;
    private String teamName;
    private String guitar;



    // 방법 1 : 연산자 오버로딩
    public Guitarist(int no) {
        this.no = no;
    }

    public Guitarist(int no, String name) {
        this(no);
        this.name = name;
    }

    public Guitarist(int no, String name, String teamName) {
        this(no, name);
        this.teamName = teamName;

    }

    // 방법 2
    public int getNo() {
        return this.no;
    }

    public void setNo(int value) {
        this.no = value;
    }


    public Guitarist(Builder builder) {
        this.no = builder.no;
        this.name = builder.name;
        this.teamName = builder.teamName;
        this.guitar = builder.guitar;
    }
    public String toString() { 
        return this.no + ", " + this.name + ", " + this.teamName + ", " + this.guitar;
    }
    // 번거로운 위 방법을 대체할 방법

    public static class Builder {
        private int no;
        private String name;
        private String teamName;
        private String guitar;

        public Builder no(int no) {
            this.no = no;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder teamName(String teamName) {
            this.teamName = teamName;
            return this;
        }


        public Builder guitar(String guitar) {
            this.guitar = guitar;
            return this;
        }

        public Guitarist build() {
            return new Guitarist(this);
        }



    }

}


class Test {
    public static void main(String[] args){

        Guitarist guitarist = new Guitarist.Builder()
            .no(1)
            .name("Randy Rhoads")
            .teamName("Quite Notes")
            .guitar("guitar")
            .build();



        System.out.println(guitarist);
    }
}
