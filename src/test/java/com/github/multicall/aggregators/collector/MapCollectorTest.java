package com.github.multicall.aggregators.collector;

import com.github.multicall.aggregators.testbeans.IntBean;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapCollectorTest {
    @Test
    public void testInt() throws Throwable {
        Collection<IntBean> beans = new IntBean().list(1, 2, 3, 4);
        Map<Integer, IntBean> map = MapCollector.collect(beans, IntBean.GET_OBJECT, new HashMap<Integer, IntBean>());
        Assert.assertEquals(4, map.size());
        Assert.assertEquals(2, map.get(2).getPrimitive());
    }

}
