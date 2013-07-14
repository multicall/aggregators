package com.github.multicall.aggregators.testbeans;

import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;

public class FloatBean extends AbstractBean<Float, FloatBean> {
    private final static Grabber<FloatBean> g = Grabber.create(FloatBean.class);
    public final static MethodCall<FloatBean, Float> GET_PRIVITIVE = g.grab(g.stub().getPrimitive(), float.class);
    public final static MethodCall<FloatBean, Float> GET_OBJECT = g.grab(g.stub().getObject(), Float.class);

    private float primitive;

    @SuppressWarnings("UnusedDeclaration")
    public FloatBean() {
    }

    public FloatBean(float value) {
        super(value);
        this.primitive = value;
    }

    protected FloatBean create(Float value) {
        return new FloatBean(value);
    }

    public float getPrimitive() {
        return primitive;
    }

    public void setPrimitive(float primitive) {
        this.primitive = primitive;
    }

    public Float getObject() {
        return object;
    }

    public void setObject(Float object) {
        this.object = object;
    }
}
