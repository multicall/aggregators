package com.github.multicall.aggregators;

import java.util.LinkedList;
import java.util.List;

public class DoubleBean {
    private double primitive;
    private Double object;

    @SuppressWarnings("UnusedDeclaration")
    public DoubleBean() {
    }

    public DoubleBean(double value) {
        this.primitive = value;
        this.object = value;
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

    public static List<DoubleBean> testCollection(double ... values) {
        List<DoubleBean> beans = new LinkedList<DoubleBean>();
        for (double value : values) {
            beans.add(new DoubleBean(value));
        }
        return beans;
    }

}
