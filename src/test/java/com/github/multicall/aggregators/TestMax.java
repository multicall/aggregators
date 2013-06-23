package com.github.multicall.aggregators;

import junit.framework.Assert;
import org.junit.Test;

public class TestMax {
    private final static Aggregator<IntBean> INT = Aggregators.create(IntBean.class);
    private final static Aggregator<DoubleBean> DOUBLE = new Aggregator<DoubleBean>(DoubleBean.class);

    @Test
    public void testIntPrimitive() throws Exception {
        Assert.assertEquals(4, INT.max(IntBean.testCollection()).getPrimitive());
    }

    @Test
    public void testIntObject() throws Exception {
        Assert.assertEquals(3, INT.max(IntBean.testCollection()).getObject().intValue());
    }

    @Test
    public void testDoublePrimitive() throws Exception {
        Assert.assertEquals(4.1, DOUBLE.max(DoubleBean.testCollection(2.7, 4.1)).getPrimitive());
    }

    @Test
    public void testDoubleObject() throws Exception {
        Assert.assertEquals(7.8, DOUBLE.max(DoubleBean.testCollection(7.8, 2.3)).getObject());
    }

}
