package com.github.multicall.aggregators;

import org.junit.Test;

import java.util.List;

public class MaxAggregatorTest extends AbstractAggregatorTest {
    @Test
    public void testBoolean() throws Exception {
        testBoolean(true, false, true);
    }

    @Test
    public void testDouble() throws Exception {
        testDouble(4.1d, 2.7d, 3.2d, 4.1d);
    }

    @Test
    public void testFloat() throws Exception {
        testFloat(4.1f, 2.7f, 3.2f, 4.1f);
    }

    @Test
    public void testInt() throws Exception {
        testInt(4, 2, 4, 3);
    }

    @Test
    public void testLong() throws Exception {
        testLong(4L, 2L, 4L, 3L);
    }

    @Override
    protected <T> T aggregate(Aggregator<T> aggregator, List<T> iterable) {
        return aggregator.max(iterable);
    }
}
