package com.jetbrains.handson.mpp.formation;

public class MyException extends Exception {

    public MyException(){
        throw new RuntimeException();
    }

    public MyException(String message) {
        throw new RuntimeException(message);
    }
}
