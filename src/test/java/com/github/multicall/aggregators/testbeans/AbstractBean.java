package com.github.multicall.aggregators.testbeans;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractBean<T, V extends AbstractBean<T, V>> {
    protected T object;

    public AbstractBean() {
    }

    public AbstractBean(T value) {
        this.object = value;
    }

    public abstract T getObject();

    public abstract void setObject(T object);

    public List<V> list(T... values) {
        List<V> beans = new LinkedList<V>();
        for (T value : values) {
            beans.add(create(value));
        }
        return beans;
    }

    protected abstract V create(T value);

}
