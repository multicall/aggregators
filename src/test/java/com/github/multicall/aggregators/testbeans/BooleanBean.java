package com.github.multicall.aggregators.testbeans;

import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;

public class BooleanBean extends AbstractBean<Boolean, BooleanBean> {
    private final static Grabber<BooleanBean> g = Grabber.create(BooleanBean.class);
    public final static MethodCall<BooleanBean, Boolean> GET_PRIVITIVE = g.grab(g.stub().getPrimitive(), boolean.class);
    public final static MethodCall<BooleanBean, Boolean> GET_OBJECT = g.grab(g.stub().getObject(), Boolean.class);

    private boolean primitive;

    @SuppressWarnings("UnusedDeclaration")
    public BooleanBean() {
    }

    public BooleanBean(boolean value) {
        super(value);
        this.primitive = value;
    }

    protected BooleanBean create(Boolean value) {
        return new BooleanBean(value);
    }

    public boolean getPrimitive() {
        return primitive;
    }

    public void setPrimitive(boolean primitive) {
        this.primitive = primitive;
    }

    public Boolean getObject() {
        return object;
    }

    public void setObject(Boolean object) {
        this.object = object;
    }
}
