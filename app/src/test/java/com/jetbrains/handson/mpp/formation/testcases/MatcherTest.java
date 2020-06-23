package com.jetbrains.handson.mpp.formation.testcases;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.core.CombinableMatcher.either;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class MatcherTest {

    @Test
    public void testMatcherCase1(){
        assertThat("dog", both(containsString("o")).and(containsString("g")));
        assertThat("dog", either(containsString("o")).or(containsString("h")));
        assertThat("dog", not(containsString("ou")));
    }

    @Test
    public void testMatcherCase2(){
        List<Object> list = new ArrayList<Object>();
        list.add("dog 1");

        List<Object> list2 = list;
        list2.add("dog 2");

        assertThat(list, is(sameInstance(list2)));
    }

    @Test
    public void testMatcherCase3(){
        List<String> list = new ArrayList<String>();
        list.add("dog 1");
        list.add("dog 2");
        list.add("dog 3");

        assertThat(list, allOf(hasItem("dog 1"), hasItem("dog 3")));
    }

    @Test
    public void testMatcherCase4(){
        List<String> list = new ArrayList<String>();
        list.add("dog 1");
        list.add("dog 2");
        list.add("dog 3");

        assertThat(list, everyItem(startsWith("dog")));
    }

    @Test
    public void testMatcherCase5(){
        List<String> list = new ArrayList<String>();
        list.add("dog 1");
        list.add("dog 2");
        list.add("dog 3");
        List<String> list2 = list;

        assertThat(list, equalTo(list2));
    }

    @Test
    public void testMatcherCase6(){
        int number = 11;
        int number2 = number;
        assertThat(number, equalTo(number2));
    }

    @Test
    public void testMatcherCase7() {
        Biscuit theBiscuit = new Biscuit("Ginger");
        Biscuit myBiscuit = new Biscuit("Ginger");
        assertThat(theBiscuit, not(equalTo(myBiscuit)));
        //assertThat(theBiscuit, equalTo(myBiscuit));
    }

    @Test
    public void testMatcherCase8(){
        Biscuit theBiscuit = new Biscuit("Ginger");
        Biscuit2 theBiscuit2 = new Biscuit2("Ginger");


        assertThat("dog", isA(String.class));
        assertThat(theBiscuit, isA(Biscuit.class));
        assertThat(theBiscuit2, isA(Biscuit.class));
    }
}

class Biscuit {
    String ginger = "";
    public Biscuit(String ginger) {
        this.ginger = ginger;
    }
}

class Biscuit2 extends Biscuit {
    public Biscuit2(String ginger) {
        super(ginger);
    }
}

