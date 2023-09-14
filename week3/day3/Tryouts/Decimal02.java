import java.util.ArrayList;
import java.util.List;

public class Decimal02 {
    
    public static void main(String[] args) {
        


        int input = 123454321;
        solution(input);

    }

    public static void solution(int input)
    {

        List<Integer> result = new ArrayList<>();
        List<Integer> decimaList = new ArrayList<>();

        int deciCal = input;
        if(input <= 2)
            {   
                result.add(input);     
            }
        else{
            while(deciCal > 2)
            {
                for(int i = 2; i<= input; i++)
                {
                    if(deciCal % i == 0)
                    {
                        deciCal /= i;
                        result.add(i);
                        break;
                    }
                }
            }
            if(deciCal == 2)
                result.add(deciCal);
        }


        for(int i : result)
        {
            System.out.println(i);
        }
    }









}
