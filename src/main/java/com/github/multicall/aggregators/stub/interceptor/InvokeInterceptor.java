package com.github.multicall.aggregators.stub.interceptor;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * The simplest interceptor that only calls specified method for each collection object. Returns null or default value for privitives.
 * @param <T> see {@link #AbstractIterableInterceptor}
 */
public class InvokeInterceptor<T> extends AbstractIterableInterceptor<T> {
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