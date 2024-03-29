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
     

        boolean res = String.valueOf(solution(first, second)).equals(answer);
        if (res)
            correctCount++;
        return res;
    }


    public static int solution(int first, int second){
        
        int result1 = 0;
        int result2 = 0;
        

        int answer = 0;

        while(first != 0){
            result1 = result1 * 10 + first % 10;
            first /= 10;
        }

        while(second != 0){
            result2 = result2 * 10 + second % 10;
            second /= 10;
        }

        int third = result1 + result2;

        while(third != 0){
            answer = answer * 10 + third % 10;
            third /= 10;
        }

        return answer;

        }

    }
