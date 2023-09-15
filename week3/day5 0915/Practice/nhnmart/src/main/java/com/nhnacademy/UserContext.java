package com.nhnacademy;

public class UserContext implements Runnable{

    private static final  ThreadLocal<Session> UserContext = new ThreadLocal<>();


    private final Integer userId;

    private final UserStore UserStore = new userStore();

    public SharedUserContext(Integer userId){
        this.userId = userId;
    }
    @Override
    public void run(){
        String userName = userStore.getUserNameByUserId(userId);
        userContext.set(new Session(userName));
        log.info("session userId: {}, userName : {}", userContext.get());
    }
    
}
