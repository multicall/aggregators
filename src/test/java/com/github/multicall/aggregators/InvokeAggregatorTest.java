package com.github.multicall.aggregators;

import com.github.multicall.aggregators.testbeans.DoubleBean;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class InvokeAggregatorTest {
    private final Aggregator<DoubleBean> aggregator = Aggregators.create(DoubleBean.class);

    @Test
    public void testReturnValue() throws Exception {
        List<DoubleBean> data = new DoubleBean().list(2.7d, 3.2d, 4.1d);
        DoubleBean bean = aggregator.all(data);
        Assert.assertEquals((double) 0, bean.getPrimitive());
        Assert.assertEquals(null, bean.getObject());
    }

    @Test
    public void testCall() throws Exception {
        List<DoubleBean> data = new DoubleBean().list(2d, 3d);
        aggregator.all(data).setPrimitive(1);
        aggregator.all(data).setObject(5D);
        Assert.assertEquals(1D, data.get(0).getPrimitive());
        Assert.assertEquals(1D, data.get(1).getPrimitive());
        Assert.assertEquals(5D, data.get(0).getObject());
        Assert.assertEquals(5D, data.get(1).getObject());
    }

}
