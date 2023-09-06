import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

    private final static Logger logger = Logger.getLogger("myLogger");

    public static MyLogger getLogger(){
        logger.setLevel(Level.INFO);
        return logger;
    }


}

class loggerTest{

    public static int sum(int a, int b){
        MyLogger.getLogger().info("덧셈 수행 : " + a + " + " + b);
        return a + b;
    }

    public static double devide(int a, int b){
        if( b == 0) {
            MyLogger.getLogger().warning("나눗셈 에러 발생!");
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(sum(a,b));
        System.out.println(devide(a,0));
    }
}



