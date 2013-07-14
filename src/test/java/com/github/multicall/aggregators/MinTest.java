package com.github.multicall.aggregators;

import org.junit.Test;

public class MinTest {
    private final static Min SUBJECT = Min.INSTANCE;

    @Test
    public void testBoolean() throws Exception {
        PrimitiveUtils.testBoolean(false, SUBJECT, false, true);
    }

    @Test
    public void testDouble() throws Exception {
        PrimitiveUtils.testDouble(2.7d, SUBJECT, 2.7d, 3.2d, 4.1d);
    }

    @Test
    public void testFloat() throws Exception {
        PrimitiveUtils.testFloat(2.7f, SUBJECT, 2.7f, 3.2f, 4.1f);
    }

    @Test
    public void testInt() throws Exception {
        PrimitiveUtils.testInt(2, SUBJECT, 2, 4, 3);
    }

    @Test
    public void testLong() throws Exception {
        PrimitiveUtils.testLong(2L, SUBJECT, 2L, 4L, 3L);
    }

}
