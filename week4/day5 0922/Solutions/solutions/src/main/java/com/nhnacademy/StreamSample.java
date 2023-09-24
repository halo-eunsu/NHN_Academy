package com.nhnacademy;

import java.util.ArrayList;
import java.util.List;

public class StreamSample {


    public static int[] getIntegers(int size) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;

        }
        return array;
    }
    // public static Stream<Integer>

    public static List<Integer> getIntegerList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }



    public static List<Guitarist> getGuitarist() {
        List<Guitarist> list = new ArrayList<>();
        list.add(new Guitarist.Builder().no(1)

        );

    }

}

class Test { 
    public static void main(String[] args) {
        int[] array = StreamSample.getIntegers(100);

        for (int i : array) {
            System.out.println(i);
        }

        List<Integer> list = StreamSample.getIntegerList(100);

        for(int i : list) {
            System.out.println(i);
        }


        IntStream intstream = StreamSample.getIntegers(100)
            .filter(x->x)
    }
}
