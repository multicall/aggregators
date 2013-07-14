package com.github.multicall.aggregators.testbeans;

import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;

public class DoubleBean extends AbstractBean<Double, DoubleBean> {
    private final static Grabber<DoubleBean> g = Grabber.create(DoubleBean.class);
    public final static MethodCall<DoubleBean, Double> GET_PRIVITIVE = g.grab(g.stub().getPrimitive(), double.class);
    public final static MethodCall<DoubleBean, Double> GET_OBJECT = g.grab(g.stub().getObject(), Double.class);

    private double primitive;

    @SuppressWarnings("UnusedDeclaration")
    public DoubleBean() {
    }

    public DoubleBean(double value) {
        super(value);
        this.primitive = value;
    }

    protected DoubleBean create(Double value) {
        return new DoubleBean(value);
    }

    public double getPrimitive() {
        return primitive;
    }

    public void setPrimitive(double primitive) {
        this.primitive = primitive;
    }

    public Double getObject() {
        return object;
    }

    public void setObject(Double object) {
        this.object = object;
    }
}
