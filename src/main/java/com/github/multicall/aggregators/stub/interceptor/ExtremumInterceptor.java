package com.github.multicall.aggregators.stub.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExtremumInterceptor<T> extends AbstractComparableInterceptor<T> {
    private boolean max = false;

    public ExtremumInterceptor(Iterable<T> objects, boolean max) {
        super(objects);
        this.max = max;
    }

    @Override
    protected <V extends Comparable<V>> V calc(Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        V ext = null;
        for (T o : objects) {
            @SuppressWarnings("unchecked")
            V value = (V) method.invoke(o, args);
            if (value != null && (ext == null || ((ext.compareTo(value) > 0) ^ max))) {
                ext = value;
            }
        }
        return ext;
    }
}
