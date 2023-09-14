package com.nhnacademy.node;

import com.nhnacademy.StringMessage;

public class TerminalOutNode extends OutputNode {
    public TerminalOutNode() {
        this(1);
    }

    public TerminalOutNode(int count) {
        super(count);
    }


    @Override
    void process(){
        for(int i = 0; i<getInputCount();i++){

            for(getInput(i).hasMessage()) {

                Mseeage message = getInput(i).get();
                
                if(message instanceof StringMessage) {
                    System.out.println(((StringMessage)message).getPayload);
                }
            }
            
        }
    }


    @Override
    public synchronized void main() {...}
}