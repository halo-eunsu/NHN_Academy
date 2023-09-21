package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
       
       
    Integer[] arr = {5,7,2,3,4,10,1,6};
       
       
       
        for(int i = 1 ; i < arr.length ; i++){

            for(int j = 0; j < arr.length -1 ; j++){
       
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }

            }

        }

        for(int a : arr){
            System.out.println(a);
        }


    }


    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}