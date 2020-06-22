package com.jetbrains.handson.mpp.formation.testcases;

import com.jetbrains.handson.mpp.formation.service.CalculatriceService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WithParameterTest {
    @Parameterized.Parameters(name = "{index}: additionsDeuxEntier({0}, {1}) = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0, 0}, { 1, 1, 2}, { 2, 1, 3 }, { 3, 2, 5 }, { 4, 3, 7 }, { 5, 5, 10 }, { 6, 8, 14 }
        });
    }

    private CalculatriceService calculatriceService;

    @Before
    public void initialize(){
        calculatriceService = new CalculatriceService();
    }

    @After
    public void clean(){
        calculatriceService = null;
    }

    @Parameterized.Parameter(0) // first data value (0) is default
    public int fInput1;

    @Parameterized.Parameter(1)
    public int fInput2;

    @Parameterized.Parameter(2)
    public int fExpected;

    @Test
    public void testAdditionsDeuxEntier(){
        int entier = calculatriceService.additionsDeuxEntier(fInput1, fInput2);
        assertEquals(entier, fExpected);
    }

}
