


public class TestProcess implements Process{
    
    public int add(int a, int b){
        return a + b;
    }
    Process add = (a, b) -> a * b;
    public static void main(String[] args) {
        
        Process p = (a, b) -> a * b;

        Process s = (a, b) -> a * b * b;

        System.out.println( p.add(1,4));

        


    }

    public int multiply(int a, int b){
        return a * b;
    }
}
