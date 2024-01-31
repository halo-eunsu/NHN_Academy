package com.nhnacademy.edu.springframework.practice.practice03;



import com.nhnacademy.edu.springframework.greeting.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {

            System.out.println("---------");
            new GreetingService(context.getBean("koreanGreeter2", Greeter.class)).greet();
            System.out.println("---------");
            new GreetingService(context.getBean("koreanGreeter2", Greeter.class)).greet();
            System.out.println("---------");
            new GreetingService(context.getBean("englishGreeter2", Greeter.class)).greet();
            System.out.println("---------");
            new GreetingService(context.getBean("englishGreeter2", Greeter.class)).greet();
            System.out.println("---------");
        }
    }
}