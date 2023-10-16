package com.nhnacademy;

import com.nhnacademy.message.StringMessage;
import com.nhnacademy.node.InputNode;
import com.nhnacademy.node.InputOutputNode;
import com.nhnacademy.node.OutputNode;

public class Main {
    public static void main(String[] args) {
        InputNode input = new InputNode(1);
        InputOutputNode inout = new InputOutputNode(1, 1);
        OutputNode output = new OutputNode(1);

        input.start();
        inout.start();
        output.start();

        input.connectOutputWire(0, inout.getOutputWire(0));
        inout.connectOutputWire(0, output.getWire(0));

        input.putMessage(new StringMessage("hi"));
        inout.putMessage(new StringMessage("hello"));

        inout.getOutputWire(0).peek();
        output.getWire(0).peek();
    }
}