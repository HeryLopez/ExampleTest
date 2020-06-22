package com.jetbrains.handson.mpp.formation;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TimeoutRuleTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1

    @Test
    public void testWS1() throws InterruptedException {
        Thread.sleep(500);
        assertThat(1, is(1));
    }
    
    @Ignore("Test is ignored as a demonstration")
    @Test
    public void testWS2() throws InterruptedException {
        Thread.sleep(1500);
        assertThat(1, is(1));
    }
}
