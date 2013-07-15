package com.github.multicall.aggregators.stub.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Calls specified method for each collection object.
 *
 * @param <T> Bean class. Must have public no-args constructor.
 */
public class InvokeInterceptor<T> implements MethodInterceptor {
    protected final Iterable<T> objects;

    public InvokeInterceptor(Iterable<T> objects) {
        this.objects = objects;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        for (T o : objects) {
            proxy.invoke(o, args);
        }
        return null;
    }
}
