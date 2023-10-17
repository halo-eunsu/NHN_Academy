import java.util.ArrayList;
import java.util.List;

public class Test {
 public static void main(String[] args) {
    
List<Integer> count = new ArrayList<>();
for(int i = 0; i< 10 ;i++){
    if(i ==1){continue;}
    if(i ==2){System.out.println(i);}
    boolean nu = true;
    if(i%2 == 0){continue;}
    for( int j : count){
        if(i % j == 0){
            nu = false;
        }
    }
    if(nu == true){
        System.out.println(i);
        count.add(i);
    }
}
 }
}
