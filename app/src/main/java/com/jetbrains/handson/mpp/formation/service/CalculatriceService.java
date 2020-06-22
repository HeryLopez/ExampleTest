package com.jetbrains.handson.mpp.formation.service;


import com.jetbrains.handson.mpp.formation.MyException;

public class CalculatriceService {

    public int additionsDeuxEntier(int i1, int i2) {
        return i1 + i2;
    }

    public void ThrowException(String message) throws MyException {
        throw new MyException(message);

      //  IndexOutOfBoundsException
    }

    public int divisionTwoNumbers(int i1, int i2) {
        return i1 / i2;
    }
}
