package com.github.multicall.aggregators.impl;

import com.github.multicall.aggregators.AbstractMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * The simplest interceptor that only calls specified method for each collection object. Returns null or default value for privitives.
 * @param <T> see {@link #AbstractMethodInterceptor}
 */
public class InvokeInterceptor<T> extends AbstractMethodInterceptor<T> {
    public InvokeInterceptor(Iterable<T> objects) {
        super(objects);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        for (T o : objects) {
            proxy.invoke(o, args);
        }
        return null;
    }
}
