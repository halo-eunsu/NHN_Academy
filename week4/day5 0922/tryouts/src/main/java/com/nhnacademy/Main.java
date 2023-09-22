package com.nhnacademy;

public class Main {
    public static void main(String[] args) {

        Integer[] array = {19, 5, 12, 47, 88, 2, 30, 76, 9, 1};

        for (int i = 0; i < array.length; i++) {
            boolean changed = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    changed = true;
                    swap(array[j], array[j + 1]);
                }
            }
            if (!changed) {
                System.out.println(i);
                break;
            }
        }

        for(int a : array){
            System.out.println(a);
        }
        
    }


    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}