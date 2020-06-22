package com.jetbrains.handson.mpp.formation.testcases;

import com.jetbrains.handson.mpp.formation.MyException;
import com.jetbrains.handson.mpp.formation.service.CalculatriceService;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


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

    @Test
    public void testAdditionsDeuxEntier(){
        int entier = calculatriceService.additionsDeuxEntier(8, 5);
        assertEquals(entier, 13);

        //fail("Pas encore mis en oeuvre!!");
    }

    @Test(expected = ArithmeticException.class)
    public void testDevisionParZero(){
        //calculatriceService.divisionTwoNumbers(5, 0);
        calculatriceService.divisionTwoNumbers(0, 5);

    }

    /*
    @Test(expected = MyException.class)
    public void testThrowException() throws MyException {
        calculatriceService.ThrowException("Mon New message");
    }
    */


    @Ignore("Test is ignored as a demonstration")
    @Test
    public void testIgnored() {
        assertThat(1, is(1));
    }




}