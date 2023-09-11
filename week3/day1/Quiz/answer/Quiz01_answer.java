import java.lang.Thread;






class Counter{
    int count = 0;
    String name = "";

    int MAX_COUNT_NUM = 10;

    public Counter(int count, String name, int MAX_COUNT_NUM){
        
        
        this.name = name;
        this.count = count;
        this.MAX_COUNT_NUM = MAX_COUNT_NUM;
    }

}


public class Quiz01_answer {

        public static void main(String[] args) throws InterruptedException{
        Counter counter = new Counter(0,"counter", 10);

        for(int i = 1 ; i<= counter.MAX_COUNT_NUM; i++)
        {
            Thread.sleep(1000);
            System.out.println(counter.name + " : " + i);
        }


    }

}


    // public static void main(String[] args) throws InterruptedException{
    //     Counter counter = new Counter(0,"counter", 10);

    //     for(int i = 1 ; i<= counter.MAX_COUNT_NUM; i++)
    //     {
    //         Thread.sleep(1000);
    //         System.out.println(counter.name + " : " + i);
    //     }


    // }
// }





// public class Quiz01_answer {
//     public static void main(String args[])
//         throws InterruptedException {
//         String importantInfo[] = {
//             "Mares eat oats",
//             "Does eat oats",
//             "Little lambs eat ivy",
//             "A kid will eat ivy too"
//         };

//         for (int i = 0;
//              i < importantInfo.length;
//              i++) {
//             //Pause for 4 seconds
//             Thread.sleep(1000);
//             //Print a message
//             System.out.println(importantInfo[i]);
//         }
//     }
// }