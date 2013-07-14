package com.github.multicall.aggregators;

import org.junit.Test;

/**
 *
 */
public class MaxTest {
    private final static Max SUBJECT = Max.INSTANCE;

    @Test
    public void testBoolean() throws Exception {
        PrimitiveUtils.testBoolean(true, SUBJECT, false, true);
    }

    @Test
    public void testDouble() throws Exception {
        PrimitiveUtils.testDouble(4.1d, SUBJECT, 2.7d, 3.2d, 4.1d);
    }

    @Test
    public void testFloat() throws Exception {
        PrimitiveUtils.testFloat(4.1f, SUBJECT, 2.7f, 3.2f, 4.1f);
    }

    @Test
    public void testInt() throws Exception {
        PrimitiveUtils.testInt(4, SUBJECT, 2, 4, 3);
    }

    @Test
    public void testLong() throws Exception {
        PrimitiveUtils.testLong(4L, SUBJECT, 2L, 4L, 3L);
    }

}
