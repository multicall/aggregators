package com.github.multicall.aggregators.testbeans;

import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;

import java.math.BigDecimal;

public class BigDecimalBean extends AbstractBean<BigDecimal, BigDecimalBean> {
    private final static Grabber<BigDecimalBean> G = Grabber.create(BigDecimalBean.class);
    public final static MethodCall<BigDecimalBean, BigDecimal> GET_OBJECT = G.grab(G.stub().getObject(), BigDecimal.class);

    @SuppressWarnings("UnusedDeclaration")
    public BigDecimalBean() {
    }

    public BigDecimalBean(BigDecimal value) {
        super(value);
    }

    protected BigDecimalBean create(BigDecimal value) {
        return new BigDecimalBean(value);
    }

    public BigDecimal getObject() {
        return object;
    }

    public void setObject(BigDecimal object) {
        this.object = object;
    }
}
