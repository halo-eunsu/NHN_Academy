import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class Decimal {
    private static final int[] TEST_CASES = {
            60,
            1000,
            123_454_321,
            2_100_000_012,
            2,
            13,
            8,
    };

    private static final ArrayList<List<Integer>> TEST_CASES_RESULT = new ArrayList<>(List.of(
            List.of(2, 2, 3, 5),
            List.of(2, 2, 2, 5, 5, 5),
            List.of(41, 41, 271, 271),
            List.of(2, 2, 3, 11, 11, 1446281),
            List.of(2),
            List.of(13),
            List.of(2, 2, 2)
    ));

    public static void main(String[] args) {
        for (int i = 0; i < TEST_CASES.length; i++) {
            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULT.get(i)));
        }
        System.out.printf("정답률 = %d%%", (int)(correct / TEST_CASES.length * 100));
    }

    private static double correct = 0;

    private static boolean test(int input, List<Integer> result) {
        if (solution(input).equals(result)) {
            correct++;
            return true;
        }
        return false;
    }




        
    public static List<Integer> solution(int input)
    {
        List<Integer> result = new ArrayList<>();
        List<Integer> decimaList = new ArrayList<>();
        

        if(input <= 2)
            {   
                result.add(input);
                return result;
            }
        for(int i = 2; i<=input; i++){
            if(input%i == 0){
                result.add(i);
                int defi = input/i;
                solution(defi);
            }

        }



        return result;
    }
    


}
