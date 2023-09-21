package com.nhnacademy;

public class Main {
    public static void main(String[] args) {
       
       
    Integer[] arr = {5,7,2,3,4,10,1,6};
       
       
       
        for(int i = 1; i < arr.length; i++){

            for(int j = 0; j < arr.length; j++){

                
                if(arr[i] > arr[j]){
                    swap(arr, j, i);
                    
                }

            }

        }

        for(int a : arr){
            System.out.println(a);
        }


    }


    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}