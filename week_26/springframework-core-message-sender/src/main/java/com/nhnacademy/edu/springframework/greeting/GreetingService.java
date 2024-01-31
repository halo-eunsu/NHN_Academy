package com.nhnacademy.edu.springframework.greeting;

//import com.nhnacademy.edu.springframework.greeting.service.Greeter;
//import com.nhnacademy.edu.springframework.greeting.stereotype.GreeterQualifier;
//import com.nhnacademy.edu.springframework.greeting.stereotype.Language;
import com.nhnacademy.edu.springframework.Greeter;
import org.springframework.beans.factory.annotation.Autowired;

public class GreetingService {

    private final Greeter greeter;

    public GreetingService(Greeter greeter) {
        this.greeter = greeter;
    }

    public boolean greet() {
        // 인터페이스의 메소드를 호출하지만 실제 구현 객체의 메소드가 실행됩니다.
        return greeter.sayHello();
    }
}
