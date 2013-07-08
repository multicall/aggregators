package com.github.multicall.aggregators.dynamic;

import com.github.multicall.aggregators.Aggregators;
import com.github.multicall.aggregators.testbeans.BooleanBean;
import com.github.multicall.aggregators.testbeans.DoubleBean;
import com.github.multicall.testutils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DynamicAggregatorTest {

    @Test
    public void testNumbers() throws Exception {
        DynamicAggregator<Number> a = Aggregators.dynamic(Number.class);
        List<? extends Number> list = Arrays.asList(1L, 2D, 3);
        @SuppressWarnings("unchecked")
        List<Number> numbers = (List<Number>) list;
        List<Integer> integers = a.flat(numbers, a.stub().intValue());
        Assert.assertEquals(2, integers.get(1).intValue());
    }

    @Test
    public void testDouble() throws Exception {
        Double[] orig = new Double[]{1.3, 2.2};
        DynamicAggregator<DoubleBean> a = Aggregators.dynamic(DoubleBean.class);

        List<DoubleBean> list = new DoubleBean().list(orig);
        Assert.assertArrayEquals(orig, a.flat(list, a.stub().getPrimitive()).toArray());
        Assert.assertArrayEquals(orig, a.flat(list, a.stub().getObject()).toArray());

        Collection<DoubleBean> coll = new DoubleBean().list(orig);
        Assert.assertArrayEquals(orig, a.flat(coll, a.stub().getPrimitive()).toArray());
        Assert.assertArrayEquals(orig, a.flat(coll, a.stub().getObject()).toArray());

        Iterable<DoubleBean> iter = new DoubleBean().list(orig);
        Assert.assertArrayEquals(orig, TestUtils.toArray(a.flat(iter, a.stub().getPrimitive())));
        Assert.assertArrayEquals(orig, TestUtils.toArray(a.flat(iter, a.stub().getObject())));
    }

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void testBoolean() throws Exception {
        Boolean[] orig = {false, true};
        DynamicAggregator<BooleanBean> a = Aggregators.dynamic(BooleanBean.class);

        List<BooleanBean> list = new BooleanBean().list(orig);
        Assert.assertArrayEquals(orig, a.flat(list, a.stub().getPrimitive()).toArray());
        Assert.assertArrayEquals(orig, a.flat(list, a.stub().getObject()).toArray());

        Collection<BooleanBean> coll = new BooleanBean().list(orig);
        Assert.assertArrayEquals(orig, a.flat(coll, a.stub().getPrimitive()).toArray());
        Assert.assertArrayEquals(orig, a.flat(coll, a.stub().getObject()).toArray());

        Iterable<BooleanBean> iter = new BooleanBean().list(orig);
        Assert.assertArrayEquals(orig, TestUtils.toArray(a.flat(iter, a.stub().getPrimitive())));
        Assert.assertArrayEquals(orig, TestUtils.toArray(a.flat(iter, a.stub().getObject())));
    }

}
