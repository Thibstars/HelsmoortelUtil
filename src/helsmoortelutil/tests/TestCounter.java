/*
 * This code has been entirely written by Thibault Helsmoortel.
 * Do not copy or (re)distribute without written permission.
 */

package helsmoortelutil.tests;

import helsmoortelutil.util.Counter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thibault Helsmoortel
 */

public class TestCounter {
    private Counter counter;

    @Before
    public void initTest() {
        this.counter = new Counter();
    }

    @Test
    public void testCurrentPosition() {
        counter.setMinVal(0);
        counter.setMaxVal(100);
        counter.setCount(50);
        Assert.assertEquals("Position must be 50.0.", 50.0, counter.currentPosition(), 0.0001);
    }

    //TODO create all necessary tests
}
