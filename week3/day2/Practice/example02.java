import java.util.ArrayList;
import java.util.List;

public class example02 {


    public static void main(String[] args) {

        int count = 0;
        int a = 1;
        int b = 10000;
        List<Integer> con = new ArrayList<>();
        boolean flag = true;
        int findCon2 = 0;

        for (int i = a; i <= b; i++) {
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
    }
}
