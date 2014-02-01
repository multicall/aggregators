package com.github.multicall.aggregators;

import com.github.multicall.aggregators.testbeans.IntBean;
import com.github.multicall.aggregators.testbeans.StringBean;
import junit.framework.Assert;
import org.junit.Test;

import static com.github.multicall.aggregators.Concat.aggregate;

public class ConcatTest {
    private final static StringBean F = new StringBean();

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void testStringEmptyList() throws Exception {
        Assert.assertEquals("", aggregate(F.list(new String[]{}), StringBean.GET_OBJECT));
    }

    @Test
    public void testString1() throws Exception {
        Assert.assertEquals("0", aggregate(F.list("0"), StringBean.GET_OBJECT));
    }

    @Test
    public void testStringNoSeparator() throws Exception {
        Assert.assertEquals("123", aggregate(F.list("1", "2", "3"), StringBean.GET_OBJECT));
    }

    @Test
    public void testStringSeparator() throws Exception {
        Assert.assertEquals("1:2:3", aggregate(F.list("1", "2", "3"), StringBean.GET_OBJECT, ":"));
    }

    @Test
    public void testInteger() throws Exception {
        Assert.assertEquals("123", aggregate(new IntBean().list(1, 2, 3), IntBean.GET_OBJECT));
    }

}
