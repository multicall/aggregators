package com.github.multicall.aggregators.testbeans;

public class FloatBean extends AbstractBean<Float, FloatBean> {
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
