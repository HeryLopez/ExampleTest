package com.jetbrains.handson.mpp.formation;

import com.jetbrains.handson.mpp.formation.service.CalculatriceService;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ThrownTest {

    private CalculatriceService calculatriceService;

    @Before // Avant chaque cas de test
    public void initialize(){
        calculatriceService = new CalculatriceService();
        //System.out.println("Before initialize");
    }

    @After
    public void clean(){
        calculatriceService = null;
        //System.out.println("After clean");
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testThrowMyException() throws MyException {
        //thrown.expect(MyException.class);
        thrown.expectMessage("Mon message");

        calculatriceService.ThrowException("Mon message");
    }

    @Test
    public void testThrowException(){
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0); // execution will never get past this line
    }

    @Test
    public void testDevisionParZero(){

        thrown.expect(ArithmeticException.class);
        calculatriceService.divisionTwoNumbers(5, 0);
        calculatriceService.divisionTwoNumbers(0, 5);

        //assertEquals(13, 13);
        //fail("Pas encore mis en oeuvre!!");
    }
}
