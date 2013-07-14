package com.github.multicall.aggregators.testbeans;

import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;

public class IntBean extends AbstractBean<Integer, IntBean> {
    private final static Grabber<IntBean> g = Grabber.create(IntBean.class);
    public final static MethodCall<IntBean, Integer> GET_PRIVITIVE = g.grab(g.stub().getPrimitive(), int.class);
    public final static MethodCall<IntBean, Integer> GET_OBJECT = g.grab(g.stub().getObject(), Integer.class);

    private int primitive;

    @SuppressWarnings("UnusedDeclaration")
    public IntBean() {
    }

    public IntBean(int value) {
        super(value);
        this.primitive = value;
    }

    protected IntBean create(Integer value) {
        return new IntBean(value);
    }

    public int getPrimitive() {
        return primitive;
    }

    public void setPrimitive(int primitive) {
        this.primitive = primitive;
    }

    public Integer getObject() {
        return object;
    }

    public void setObject(Integer object) {
        this.object = object;
    }
}
