package com.nhnacademy;


//workerpool 한다는거부터 싱크 맞추기

public class WorkerPool {
    
    private final Worker[] workers;

    public WorkerPool(int poolSize, Channel channel){

        workers = new Worker[poolSize];
        for( int i = 0; i < poolSize; i++){
            Employee employee = EmployeeGenerator.getEmployeeGenerator().next();
            workers[i] = new Worker(channel, employee);

        }
    }




    
}
