package com.nhnacademy.aiot;

import java.util.ArrayList;
import java.util.List;

public class FInd {
    public static int oneToconv(int a) {

        int count2 = 0;
        List<Integer> con = new ArrayList<>();
        boolean flag = true;

        for (int i = 1; i <= a; i++) {
            if (i == 1)
                continue;
            if (i == 2) {
                count2++;
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
                    count2++;
                }
            } else {
                con.add(i);
                count2++;
            }

        }

        // System.out.println("count2 : " + count2);
        return count2;

    }
}
