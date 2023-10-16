package com.nhnacademy.node;

import com.nhnacademy.exception.OutOfBoundsException;
import com.nhnacademy.message.Message;
import com.nhnacademy.message.StringMessage;
import com.nhnacademy.wire.Wire;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputOutputNode extends Node {
    Wire[] inputWires;
    Wire[] outputWires;

    public InputOutputNode(String name, int inCount, int outCount) {
        super(name);

        inputWires = new Wire[inCount];
        outputWires = new Wire[outCount];
        // for (int i = 0; i < outCount; i++) {
        // outputWires[i] = new Wire();
        // }
        log.info("in out node created : {}", getName());
    }

    public InputOutputNode(int inCount, int outCount) {
        super();

        inputWires = new Wire[inCount];
        outputWires = new Wire[outCount];
        // for (int i = 0; i < outCount; i++) {
        // outputWires[i] = new Wire();
        // }
        log.info("in out node created : {}", getName());
    }

    // wire 가져오기
    public Wire getOutputWire(int index) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return outputWires[index];
    }

    public Wire getInputWire(int index) {
        if (index < 0 || inputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        return inputWires[index];
    }

    // input 노드에 wire 연결
    public void connectOutputWire(int index, Wire wire) {
        if (index < 0 || outputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        outputWires[index] = wire;
        log.info("{} connect {}", getName(), index);
    }

    public int getOutputWireCount() {
        return outputWires.length;
    }

    public int getInputWireCount() {
        return inputWires.length;
    }

    // 와이어에 메세지 저장
    public void putMessage(Message message) {
        log.info("Message Out ready");
        for (Wire wire : outputWires) {
            if (wire != null) {
                wire.put(message);
                log.info("out message : {}", ((StringMessage) message).getStringValue());
            }
        }
        log.info("Message Out success");
    }

    public void connectInputWire(int index, Wire wire) {
        if (index < 0 || inputWires.length <= index) {
            throw new OutOfBoundsException();
        }

        inputWires[index] = wire;
    }

    // 특정 와이어에만 메세지 저장
    public void putMessage(int index, Message message) {
        log.info("message input ready : {}", getName());
        inputWires[index].put(message);
        log.info("{} put message : {}", getName(), message.toString());
    }


    void output(Message message) {
        log.trace("Message Out");
        for (Wire port : outputWires) {
            if (port != null) {
                port.put(message);
            }
        }
    }

    
}
