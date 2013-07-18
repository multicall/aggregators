package com.github.multicall.aggregators;

import com.github.multicall.aggregators.testbeans.AbstractBean;
import com.github.multicall.aggregators.testbeans.BooleanBean;
import com.github.multicall.aggregators.testbeans.DoubleBean;
import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;
import com.github.multicall.testutils.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatTest {
    @Test
    public void testNumbers() throws Exception {
        Grabber<Number> g = Grabber.create(Number.class);
        MethodCall<Number, Integer> intValue = g.grab(g.stub().intValue(), int.class);

        List<? extends Number> list = Arrays.asList(1L, 2D, 3);
        @SuppressWarnings("unchecked")
        List<Number> numbers = (List<Number>) list;
        List<Integer> integers = Flat.list(numbers, intValue);
        Assert.assertEquals(2, integers.get(1).intValue());
    }

    @Test
    public void testDouble() throws Exception {
        test(new Double[]{1.3, 2.2}, DoubleBean.GET_PRIVITIVE, DoubleBean.GET_OBJECT, new DoubleBean());
    }

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void testBoolean() throws Exception {
        test(new Boolean[]{false, true}, BooleanBean.GET_PRIVITIVE, BooleanBean.GET_OBJECT, new BooleanBean());
    }

    private <T, V extends AbstractBean<T, V>> void test(T[] orig, MethodCall<V, T> getPrivitive, MethodCall<V, T> getObject, V stub) {
        List<V> list = stub.list(orig);
        Assert.assertArrayEquals(orig, Flat.list(list, getPrivitive).toArray());
        Assert.assertArrayEquals(orig, Flat.list(list, getObject).toArray());

        Collection<V> coll = stub.list(orig);
        Assert.assertArrayEquals(orig, Flat.collection(coll, getPrivitive).toArray());
        Assert.assertArrayEquals(orig, Flat.collection(coll, getObject).toArray());

        Iterable<V> iter = stub.list(orig);
        Assert.assertArrayEquals(orig, TestUtils.toArray(Flat.iterable(iter, getPrivitive)));
        Assert.assertArrayEquals(orig, TestUtils.toArray(Flat.iterable(iter, getObject)));
    }

}
