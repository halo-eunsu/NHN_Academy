import java.io.IOException;

public class Test {
    


    public static void main(String[] args) throws IOException {
        GoCSV goCSV = new GoCSV("/home/jeongeunsu/\uBB38\uC11C/NHN_git_test/NHN_Academy/week2/day4/example/movies.csv");
        String[] line=null;
        while((line = goCSV.nextRead())!=null){
            for(String a : line){
                System.out.print(a +", ");
            }
            System.out.println();
        }
    }
}
