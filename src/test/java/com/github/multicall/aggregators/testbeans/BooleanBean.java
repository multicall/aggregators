package com.github.multicall.aggregators.testbeans;

public class BooleanBean extends AbstractBean<Boolean, BooleanBean> {
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
