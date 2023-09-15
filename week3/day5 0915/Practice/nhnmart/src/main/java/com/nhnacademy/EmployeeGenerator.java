package com.nhnacademy;

import java.util.NoSuchElementException;

public class EmployeeGenerator {
    


    private static final Atomiclong ID_GENERATOR = new AtomicLong();


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


    }

    
}
