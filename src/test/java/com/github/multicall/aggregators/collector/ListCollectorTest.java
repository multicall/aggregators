package com.github.multicall.aggregators.collector;

import com.github.multicall.aggregators.testbeans.IntBean;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

public class ListCollectorTest {
    @Test
    public void testInt() throws Throwable {
        Collection<IntBean> beans = new IntBean().list(1, 2, 3, 4);
        LinkedList<Integer> list = ListCollector.collect(beans, IntBean.GET_OBJECT, new LinkedList<Integer>());
        Assert.assertEquals(4, list.size());
        Assert.assertEquals((Integer) 1, list.get(0));
        Assert.assertEquals((Integer) 2, list.get(1));
    }

}
