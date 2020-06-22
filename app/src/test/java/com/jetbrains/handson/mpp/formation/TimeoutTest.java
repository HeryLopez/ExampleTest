package com.jetbrains.handson.mpp.formation;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TimeoutTest {

    @Test(timeout=1000)
    public void testWS1() throws InterruptedException {
        Thread.sleep(500);
        assertThat(1, is(1));
    }

    @Test(timeout=1000)
    public void testWS2() throws InterruptedException {
        Thread.sleep(1500);
        assertThat(1, is(1));
    }
}
