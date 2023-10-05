package com.nhnacademy.aiot;

public class InvalidMethodException extends RuntimeException {
    public InvalidMethodException(String method) {
        super("Unsupported method : " + method);
    }
}
