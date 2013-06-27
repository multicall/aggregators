package com.github.multicall.aggregators.testbeans;

public class IntBean extends AbstractBean<Integer, IntBean> {
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
