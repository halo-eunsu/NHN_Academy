public class Main {

    private static double correctCount = 0;

    private static final String[][] TESTCASES = new String[][] {
            {"123", "123", "246"},
            {"1000", "1", "2"},
            {"456", "789", "1461"},
            {"5", "5", "1"},
            {"11112", "54321", "65433"},
            {"3829", "1300", "4139"}
    };

    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++)
            System.out.println("Testcase " + i + " = " + test(TESTCASES[i][0], TESTCASES[i][1], TESTCASES[i][2]));

        System.out.println("정답률 = " + (int) (correctCount / TESTCASES.length * 100) + "%");
    }

    private static boolean test(String input, String input2, String answer) {
        int first = Integer.parseInt(input);
        int second = Integer.parseInt(input2);
        System.out.println(first);
        System.out.println(second);

        boolean res = String.valueOf(solution(first, second)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }


    public static int solution(int first, int second){
        
        
        String first1 = "";
        String second1 = "";

        String res1 = "";
        String res2 = "";

        String res3 = "";

        first1 += first;
        System.out.println(first1);
        // second1 += second;

        

        // for(int i = first1.length()-1; i > 0 ; i--){

        //     char c = first1.charAt(i);
        //     res1 += c;


        // }

        // for(int i = second1.length()-1; i > 0 ; i--){

        //     char c = second1.charAt(i);
        //     res2 += c;


        // }

        // first = Integer.parseInt(res1);
        // second = Integer.parseInt(res2);

        // int third = first + second;
        // res3 += third;

        // for(int i = res3.length()-1; i > 0 ; i--){

        //     char c = res3.charAt(i);
        //     res3 += c;


        // }

        // int result = Integer.parseInt(res3);

        // return result;

            return 0;
        
    }



}
