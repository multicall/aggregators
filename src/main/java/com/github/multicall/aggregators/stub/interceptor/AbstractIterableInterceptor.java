package com.github.multicall.aggregators.stub.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Abstract superclass for method interceptors. Holds the collection being processed
 * @param <T> Bean class. Must have public no-args constructor.
 */
public abstract class AbstractIterableInterceptor<T> implements MethodInterceptor {
    protected final Iterable<T> objects;

    public AbstractIterableInterceptor(Iterable<T> objects) {
        this.objects = objects;
    }
}
