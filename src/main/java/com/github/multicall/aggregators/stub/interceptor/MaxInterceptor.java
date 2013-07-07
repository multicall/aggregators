package com.github.multicall.aggregators.stub.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MaxInterceptor<T> extends AbstractComparableInterceptor<T> {
    public MaxInterceptor(Iterable<T> objects) {
        super(objects);
    }

    @Override
    protected <V extends Comparable<V>> V calc(Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        V max = null;
        for (T o : objects) {
            @SuppressWarnings("unchecked")
            V value = (V) method.invoke(o, args);
            if (value != null && (max == null || max.compareTo(value) < 0)) {
                max = value;
            }
        }
        return max;
    }
}
