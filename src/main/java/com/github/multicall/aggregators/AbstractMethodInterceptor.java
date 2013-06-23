package com.github.multicall.aggregators;

import net.sf.cglib.proxy.MethodInterceptor;

public abstract class AbstractMethodInterceptor<T> implements MethodInterceptor {
    protected Iterable<T> objects;

    public AbstractMethodInterceptor(Iterable<T> objects) {
        this.objects = objects;
    }
}
