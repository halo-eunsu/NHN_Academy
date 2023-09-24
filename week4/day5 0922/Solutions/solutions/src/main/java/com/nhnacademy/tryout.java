package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;

public class tryout {
    public static void main(String[] args) {
        
        List<Integer> max = new ArrayList<>();
        int count = 0;

        int[] a = {61, 33, 27, 6, 14, 78, 50, 38, 59, 68};
        int[] b = {6, 14, 27, 33, 38, 50, 59, 61, 68, 78};

        for(int i = 0; i<a.length;i++){

            for(int j = 0;j<b.length;j++){


                if (a[i] == b[j]) {
                    int area = i - j;

                    max.add(area);
                }
            }
            
        }
        

        for(int k = 0; k<max.size();k++){
            
            
            if(max.get(k) >= count){
                count = max.get(k);
            }            
        }

        for(int i : max){
            System.out.println(i);
        }

        System.out.println("count : "+count);
              
      

        
    
    }
}
