package com.github.multicall.aggregators;

import com.github.multicall.aggregators.testbeans.BigDecimalBean;
import com.github.multicall.aggregators.testbeans.DoubleBean;
import com.github.multicall.aggregators.testbeans.FloatBean;
import com.github.multicall.aggregators.testbeans.IntBean;
import com.github.multicall.aggregators.testbeans.LongBean;
import com.github.multicall.math.Arithmetics;
import junit.framework.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public class SumTest {
    @Test
    public void testIntPrimitive() throws Throwable {
        Sum<IntBean, Integer> subj = new Sum<IntBean, Integer>(IntBean.GET_OBJECT, Arithmetics.INTEGER);
        Assert.assertEquals(6, (int) subj.run(new IntBean().list(1, 2, 3)));
    }

    @Test
    public void testLongPrimitive() throws Throwable {
        Sum<LongBean, Long> subj = new Sum<LongBean, Long>(LongBean.GET_OBJECT, Arithmetics.LONG);
        Assert.assertEquals(6, (long) subj.run(new LongBean().list(1L, 2L, 3L)));
    }


    @Test
    public void testFloatPrimitive() throws Throwable {
        Sum<FloatBean, Float> subj = new Sum<FloatBean, Float>(FloatBean.GET_OBJECT, Arithmetics.FLOAT);
        Assert.assertEquals(6.6f, subj.run(new FloatBean().list(1.1f, 2.2f, 3.3f)), 0.0001);
    }

    @Test
    public void testDoublePrimitive() throws Throwable {
        Sum<DoubleBean, Double> subj = new Sum<DoubleBean, Double>(DoubleBean.GET_OBJECT, Arithmetics.DOUBLE);
        Assert.assertEquals(6.6d, subj.run(new DoubleBean().list(1.1, 2.2, 3.3)), 0.00000001);
    }

    @Test
    public void testBigDecimal() throws Throwable {
        Sum<BigDecimalBean, BigDecimal> subj = new Sum<BigDecimalBean, BigDecimal>(BigDecimalBean.GET_OBJECT, Arithmetics.BIG_DECIMAL);
        Assert.assertEquals(new BigDecimal("6.6"), subj.run(new BigDecimalBean().list(new BigDecimal("1.1"), new BigDecimal("2.2"), new BigDecimal("3.3"))));
    }

    @Test
    public void testBigDecimal_null() throws Throwable {
        Sum<BigDecimalBean, BigDecimal> subj = new Sum<BigDecimalBean, BigDecimal>(BigDecimalBean.GET_OBJECT, Arithmetics.BIG_DECIMAL);
        Assert.assertEquals(new BigDecimal("4.4"), subj.run(new BigDecimalBean().list(new BigDecimal("1.1"), null, new BigDecimal("3.3"))));
    }

    @Test
    public void testArray() throws Throwable {
        Sum<IntBean, Integer> subj = new Sum<IntBean, Integer>(IntBean.GET_OBJECT, Arithmetics.INTEGER);
        List<IntBean> list = new IntBean().list(1, 2, 3);
        Assert.assertEquals(6, (int) subj.run(list.toArray(new IntBean[list.size()])));
    }

}
