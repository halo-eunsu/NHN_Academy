package com.nhnacademy.edu.springframework.practice.practice04;



import com.nhnacademy.edu.springframework.greeting.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {


            new GreetingService(context.getBean("englishGreeter3", Greeter.class)).greet();
            System.out.println("---------");
        }
    }
}