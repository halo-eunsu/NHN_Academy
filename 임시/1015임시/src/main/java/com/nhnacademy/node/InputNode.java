package com.nhnacademy.node;

import com.nhnacademy.exception.AlreadyConnectedException;
import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.exception.OutofWireCountException;
import com.nhnacademy.message.Message;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputNode extends Node {
    Wire[] outputWires;
    int wireCount;

    public InputNode(int wireCount) {
        super();
        outputWires = new Wire[wireCount];
        log.info("input node created {}", getName());
    }

    public InputNode(String name, int wireCount) {
        super(name);
        outputWires = new Wire[wireCount];
        log.info("input node created {}", getName());
    }

    public void connectOutputWire(int index, Wire wire) {
        if (index > wireCount) {
            throw new OutofWireCountException();
        }

        if (outputWires[index] != null) {
            throw new AlreadyConnectedException();
        }

        outputWires[index] = wire;
        log.info("{} connected {}", getName(), index);
    }

    public int getOutputWireCount() {
        return outputWires.length;
    }

    public void putMessage(Message message) {
        boolean accept = true;

        for (Wire wire : outputWires) {
            accept = accept && wire.getMessageQueue().isEmpty();
        }
        log.info("output ready : {}", getName());
        if (accept) {
            for (Wire wire : outputWires) {
                wire.put(message);
                log.info("message put : {}", message);
            }
        }
        log.info("output success");
    }


    public Wire getoutputWire(int index) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return outputWires[index];
    }

    public void putMessage(int index, Message message) {
        log.info("message input ready : {}", getName());
        outputWires[index].put(message);
        log.info("{} put message : {}", getName(), message.toString());
    }

}
