package com.github.multicall.aggregators.stub;

import com.github.multicall.aggregators.Aggregators;
import com.github.multicall.aggregators.testbeans.DoubleBean;
import com.github.multicall.aggregators.testbeans.ParentBean;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class MinAggregatorTest extends AbstractAggregatorTest {
    @Test
    public void testBoolean() throws Exception {
        testBoolean(false, false, true);
    }

    @Test
    public void testArray() throws Exception {
        StubAggregator<DoubleBean> a = Aggregators.create(DoubleBean.class);
        DoubleBean max = a.min(new DoubleBean(2.7), new DoubleBean(3.3));
        Assert.assertEquals(2.7d, max.getPrimitive());
        Assert.assertEquals(2.7d, max.getObject());
    }

    @Test
    public void testDouble() throws Exception {
        testDouble(2.7d, 2.7d, 3.2d, 4.1d);
    }

    @Test
    public void testFloat() throws Exception {
        testFloat(2.7f, 2.7f, 3.2f, 4.1f);
    }

    @Test
    public void testInt() throws Exception {
        testInt(2, 2, 4, 3);
    }

    @Test
    public void testLong() throws Exception {
        testLong(2L, 2L, 4L, 3L);
    }

    @Test
    public void testNotComparable() throws Exception {
        ParentBean bean1 = new ParentBean();
        ParentBean bean2 = new ParentBean();
        Assert.assertNull(testObject(ParentBean.class, bean1, bean2).getObject());
        //TODO assert that method has been called
    }

    @Override
    protected <T> T aggregate(StubAggregator<T> aggregator, List<T> iterable) {
        return aggregator.min(iterable);
    }
}
