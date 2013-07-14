package com.github.multicall.aggregators.testbeans;

import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;

public class LongBean extends AbstractBean<Long, LongBean> {
    private final static Grabber<LongBean> g = Grabber.create(LongBean.class);
    public final static MethodCall<LongBean, Long> GET_PRIVITIVE = g.grab(g.stub().getPrimitive(), long.class);
    public final static MethodCall<LongBean, Long> GET_OBJECT = g.grab(g.stub().getObject(), Long.class);

    private long primitive;

    @SuppressWarnings("UnusedDeclaration")
    public LongBean() {
    }

    public LongBean(long value) {
        super(value);
        this.primitive = value;
    }

    protected LongBean create(Long value) {
        return new LongBean(value);
    }

    public long getPrimitive() {
        return primitive;
    }

    public void setPrimitive(long primitive) {
        this.primitive = primitive;
    }

    public Long getObject() {
        return object;
    }

    public void setObject(Long object) {
        this.object = object;
    }
}
