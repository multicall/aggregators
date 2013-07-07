package com.github.multicall.aggregators.stub;

import com.github.multicall.aggregators.Aggregators;
import com.github.multicall.aggregators.testbeans.BooleanBean;
import com.github.multicall.aggregators.testbeans.DoubleBean;
import com.github.multicall.aggregators.testbeans.FloatBean;
import com.github.multicall.aggregators.testbeans.IntBean;
import com.github.multicall.aggregators.testbeans.LongBean;
import junit.framework.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * Provides convenience methods to do joint testing on primitives and corresponding object types
 */
public abstract class AbstractAggregatorTest {
    protected abstract <T> T aggregate(StubAggregator<T> aggregator, List<T> iterable);

    protected void testBoolean(boolean expected, Boolean... values) {
        BooleanBean bean = aggregate(Aggregators.create(BooleanBean.class), new BooleanBean().list(values));
        Assert.assertEquals(expected, bean.getPrimitive());
        Assert.assertEquals(Boolean.valueOf(expected), bean.getObject());
    }

    protected void testDouble(double expected, Double... values) {
        DoubleBean bean = aggregate(Aggregators.create(DoubleBean.class), new DoubleBean().list(values));
        Assert.assertEquals(expected, bean.getPrimitive());
        Assert.assertEquals(expected, bean.getObject());
    }

    protected void testFloat(float expected, Float... values) {
        FloatBean bean = aggregate(Aggregators.create(FloatBean.class), new FloatBean().list(values));
        Assert.assertEquals(expected, bean.getPrimitive());
        Assert.assertEquals(expected, bean.getObject());
    }

    protected void testInt(int expected, Integer... values) {
        IntBean bean = aggregate(Aggregators.create(IntBean.class), new IntBean().list(values));
        Assert.assertEquals(expected, bean.getPrimitive());
        Assert.assertEquals(Integer.valueOf(expected), bean.getObject());
    }

    protected void testLong(long expected, Long... values) {
        LongBean bean = aggregate(Aggregators.create(LongBean.class), new LongBean().list(values));
        Assert.assertEquals(expected, bean.getPrimitive());
        Assert.assertEquals(Long.valueOf(expected), bean.getObject());
    }

    protected <T> T testObject(Class<T> clazz, T... values) {
        return aggregate(Aggregators.create(clazz), Arrays.asList(values));
    }

}
