package com.nhnacademy.aiot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // solution


    public static int solution(int a, int b) {

        int count = 0;



        List<Integer> con = new ArrayList<>();
        boolean flag = true;
        int findCon2 = 0;

        for (int i = 1; i <= b; i++) {
            if (i == 1)
                continue;
            if (i == 2) {
                count++;
            }
            if (i % 2 == 0) {
                continue;
            }
            if (con.size() != 0) {
                for (int j = 0; j < con.size(); j++) {

                    int findCon = con.get(j);
                    int findres = i % con.get(j);
                    if (i % con.get(j) == 0) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
                if (flag == true) {
                    con.add(i);
                    count++;
                }
            } else {
                con.add(i);
                count++;
            }

        }

        System.out.println("count : " + count);

        int count2 = FInd.oneToconv(a - 1);
        System.out.println("count2 : " + count2);

        int result = count - count2;

        System.out.println("result : " + result);



        return result;
    }

}
