package com.nhnacademy;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeGenerator {
    


    private static final AtomicLong ID_GENERATOR = new AtomicLong();


    private static final EmployeeGenerator INSTANCE = new EmployeeGenerator();

    public EmployeeGenerator getEmployeeGenerator(){
        return INSTANCE;
    }

    @Override
    public boolean hasNest(){
        return true;

    }

    @Override
    public Employee next(){
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return new Employee(ID_GENERATOR.incrementAndGet(), "직원" + ID_GENERATOR.get());

    }

    
}
