package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyExistsException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.exception.OutofWireCountException;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OutputNode extends Node {
    Wire[] inputWires;
    int wireCount;

    public OutputNode(int wireCount) {
        super();
        inputWires = new Wire[wireCount];
        log.info("output node created : {}", getName());
    }

    public OutputNode(String name, int wireCount) {
        super(name);
        inputWires = new Wire[wireCount];
        for (int i = 0; i < wireCount; i++) {
            inputWires[i] = new Wire();
        }
        log.info("output node created : {}", getName());
    }

    public void connectInputWire(int index, Wire wire) {
        if (inputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        if (inputWires[index] != null) {
            throw new AlreadyExistsException();
        }

        inputWires[index] = wire;
    }

    public int getInputWireCount() {
        return inputWires.length;
    }

    // 와이어 가져오기
    public Wire getWire(int index) {
        if (wireCount < index) {
            throw new OutofWireCountException();
        }
        return inputWires[index];
    }

}
