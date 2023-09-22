package com.nhnacademy;
@FunctionalInterface

public interface BinaryOp {
    
    public int apply(int a, int b);

}

class Adder implements BinaryOp {

    public int apply(int i, int j){
        return i + j;
    }
}

class Mult implements BinaryOp { 
    public int apply(int i, int j){
        return i * j;
    }
}


class Algo{


    public static int calc(BinaryOp binder, int i, int j){ 
        return binder.apply(i,j);
    }

    BinaryOp adder = new BinaryOp() {
        public int apply(int i, int j) { 
            return i + j;
        }

    };


    public static void main(String[] args) { 
        System.out.println(calc((a, b) -> a % b, 1, 2));
    }
}