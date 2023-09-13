import java.util.ArrayList;
import java.util.List;

public class Decimal {
 
    
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
    
    public static void main(String[] args) {
        
        int input = 16;
        List<Integer> a = solution(input);

        for(int i : a){
            System.out.println(i);
        }

    }



}
