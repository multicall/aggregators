package com.github.multicall.aggregators.stub.interceptor;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Provides logic to distinguish comparable objects. Defaults to {@link #InvokeInterceptor} for other objects.
 * @param <T>
 */
public abstract class AbstractComparableInterceptor<T> extends InvokeInterceptor<T> {
    public AbstractComparableInterceptor(Iterable<T> objects) {
        super(objects);
    }

    @SuppressWarnings("RedundantTypeArguments")
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Class<?> type = method.getReturnType();
        if (type.isPrimitive() || Comparable.class.isAssignableFrom(type)) {
            return this.<Comparable>calc(method, args);
        } else {
            return super.intercept(obj, method, args, proxy);
        }
    }

    protected abstract <V extends Comparable<V>> V calc(Method method, Object[] args) throws IllegalAccessException, InvocationTargetException;
}
