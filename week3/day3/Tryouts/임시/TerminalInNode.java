package com.nhnacademy;

import java.util.Scanner;

public class TerminalInNode extends InputNode {
    Scanner scanner;

    public TerminalInNode() {
        this(1);
        
    }

    public TErminalInNode(int count) {
        super(count);
        scanner = new Scanner(System.in);
    }

    @Override
    void process(){
        String line = scanner.nextLine();
        StringMessage message = new StringMessage(line);

        output(message);
        
    }
    
    @Override
    void preprocess(){
        scanner = new Scanner(System.in);
        setInterval(1);
    }

    @Override
    public synchronized void main() {...}

    @Override
    void postprocess(){
        scanner = null;
    }
}