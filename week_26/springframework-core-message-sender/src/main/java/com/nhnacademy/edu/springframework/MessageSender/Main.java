package com.nhnacademy.edu.springframework.MessageSender;

public class Main {

    User user = new User(
            "byong",
            "010-1111-2222"
    );

    new MessageSendService(new SmsMessageSender()
        .doSendMessage(user, "밥먹자"));

    new NessageSendService(new Emai)
}
