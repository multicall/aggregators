package com.github.multicall.grabber;

import com.github.multicall.aggregators.testbeans.DoubleBean;
import org.junit.Assert;
import org.junit.Test;

public class GrabberTest {
    private DoubleBean bean = new DoubleBean(1.2);

    @Test
    public void testGrabClass() throws Throwable {
        Grabber<DoubleBean> g = Grabber.create(DoubleBean.class);
        MethodCall<DoubleBean, Double> method = g.grab(g.stub().getObject()).returns(Double.class);
        Assert.assertEquals(bean.getObject(), method.replay(bean));
    }

    @Test
    public void testGrabPrimitive() throws Throwable {
        Grabber<DoubleBean> g = Grabber.create(DoubleBean.class);
        MethodCall<DoubleBean, Double> method = g.grab(g.stub().getPrimitive(), double.class);
        Assert.assertEquals((Double) bean.getPrimitive(), method.replay(new DoubleBean(1.2)));
    }
}
