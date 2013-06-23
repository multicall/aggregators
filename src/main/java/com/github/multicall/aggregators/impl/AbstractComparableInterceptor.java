package com.github.multicall.aggregators.impl;

import com.github.multicall.aggregators.AbstractMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractComparableInterceptor<T> extends AbstractMethodInterceptor<T> {
    public AbstractComparableInterceptor(Iterable<T> objects) {
        super(objects);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Class<?> type = method.getReturnType();
        if (type.isPrimitive() || Comparable.class.isAssignableFrom(type)) {
            return this.<Comparable>calc(method, args);
        } else {
            throw new UnsupportedOperationException("Method return type must be assignment compatible with Comparable");
        }
    }

    protected abstract <V extends Comparable<V>> V calc(Method method, Object[] args) throws IllegalAccessException, InvocationTargetException;
}
