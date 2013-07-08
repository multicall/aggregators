package com.github.multicall.aggregators.stub;

import com.github.multicall.aggregators.Aggregators;
import com.github.multicall.aggregators.testbeans.DoubleBean;
import com.github.multicall.aggregators.testbeans.NestedBean;
import com.github.multicall.aggregators.testbeans.ParentBean;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InvokeAggregatorTest {
    private final StubAggregator<DoubleBean> aggregator = Aggregators.create(DoubleBean.class);

    @Test
    public void testReturnValue() throws Exception {
        List<DoubleBean> data = new DoubleBean().list(2.7d, 3.2d, 4.1d);
        DoubleBean bean = aggregator.all(data);
        Assert.assertEquals((double) 0, bean.getPrimitive());
        Assert.assertEquals(null, bean.getObject());
    }

    @Test
    public void testCallDouble() throws Exception {
        DoubleBean[] data = new DoubleBean[]{new DoubleBean(2d), new DoubleBean(3d)};
        aggregator.all(data).setPrimitive(1);
        aggregator.all(data).setObject(5D);
        Assert.assertEquals(1D, data[0].getPrimitive());
        Assert.assertEquals(1D, data[1].getPrimitive());
        Assert.assertEquals(5D, data[0].getObject());
        Assert.assertEquals(5D, data[1].getObject());
    }

    @Test
    public void testCallObject() throws Exception {
        NestedBean nestedBean = new NestedBean();
        ParentBean parentBean = new ParentBean();
        StubAggregator<ParentBean> a = new StubAggregator<ParentBean>(ParentBean.class);
        a.all(Arrays.asList(parentBean)).setObject(nestedBean);
        Assert.assertSame(nestedBean, parentBean.getObject());
    }

}
