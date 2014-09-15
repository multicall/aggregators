package com.github.multicall.aggregators.testbeans;

import com.github.multicall.grabber.Grabber;
import com.github.multicall.grabber.MethodCall;

public class StringBean extends AbstractBean<String, StringBean> {
    private final static Grabber<StringBean> g = Grabber.create(StringBean.class);
    public final static MethodCall<StringBean, String> GET_OBJECT = g.grab(g.stub().getObject(), String.class);

    public StringBean() {
    }

    public StringBean(String value) {
        super(value);
    }

    protected StringBean create(String value) {
        return new StringBean(value);
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
