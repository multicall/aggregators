package com.github.multicall.aggregators;

import com.github.multicall.aggregators.testbeans.BooleanBean;
import com.github.multicall.aggregators.testbeans.DoubleBean;
import com.github.multicall.aggregators.testbeans.FloatBean;
import com.github.multicall.aggregators.testbeans.IntBean;
import com.github.multicall.aggregators.testbeans.LongBean;
import com.github.multicall.testutils.BeanSubject;
import junit.framework.Assert;

/**
 *
 */
public class PrimitiveUtils {
    public static void testBoolean(boolean expected, BeanSubject subject, Boolean... values) {
        Iterable<BooleanBean> beans = new BooleanBean().list(values);
        Assert.assertEquals(expected, (boolean) subject.aggregate(beans, BooleanBean.GET_PRIVITIVE));
        Assert.assertEquals((Boolean) expected, subject.aggregate(beans, BooleanBean.GET_OBJECT));
    }

    public static void testDouble(double expected, BeanSubject subject, Double... values) {
        Iterable<DoubleBean> beans = new DoubleBean().list(values);
        Assert.assertEquals(expected, subject.aggregate(beans, DoubleBean.GET_PRIVITIVE));
        Assert.assertEquals(expected, subject.aggregate(beans, DoubleBean.GET_OBJECT));
    }

    public static void testFloat(float expected, BeanSubject subject, Float... values) {
        Iterable<FloatBean> beans = new FloatBean().list(values);
        Assert.assertEquals(expected, subject.aggregate(beans, FloatBean.GET_PRIVITIVE));
        Assert.assertEquals(expected, subject.aggregate(beans, FloatBean.GET_OBJECT));
    }

    public static void testInt(int expected, BeanSubject subject, Integer... values) {
        Iterable<IntBean> beans = new IntBean().list(values);
        Assert.assertEquals(expected, (int) subject.aggregate(beans, IntBean.GET_PRIVITIVE));
        Assert.assertEquals((Integer) expected, subject.aggregate(beans, IntBean.GET_OBJECT));
    }

    public static void testLong(long expected, BeanSubject subject, Long... values) {
        Iterable<LongBean> beans = new LongBean().list(values);
        Assert.assertEquals(expected, (long) subject.aggregate(beans, LongBean.GET_PRIVITIVE));
        Assert.assertEquals((Object) expected, subject.aggregate(beans, LongBean.GET_OBJECT));
    }
}
