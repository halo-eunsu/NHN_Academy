package main.java.com.nhnacademy;

public class PCSolution01 {
   
    public static void main(String[] args) {
        Store store = new Store(3);
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer("C1", store);
        
        producer.start();       
        consumer.start();       

    }
}
