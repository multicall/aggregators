package com.github.multicall.aggregators.testbeans;

public class LongBean extends AbstractBean<Long, LongBean> {
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
