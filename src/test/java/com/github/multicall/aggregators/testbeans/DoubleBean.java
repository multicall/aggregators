package com.github.multicall.aggregators.testbeans;

public class DoubleBean extends AbstractBean<Double, DoubleBean> {
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
