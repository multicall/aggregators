package com.github.multicall.aggregators;

import com.github.multicall.aggregators.impl.InvokeInterceptor;
import com.github.multicall.aggregators.impl.MaxInterceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class Aggregator<T> {
    private Class<T> clazz;

    Aggregator(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T all(Iterable<T> iterable) {
        return spawn(new InvokeInterceptor<T>(iterable));
    }

    public T max(Iterable<T> iterable) {
        return spawn(new MaxInterceptor<T>(iterable));
    }

    @SuppressWarnings("unchecked")
    T spawn(MethodInterceptor callback) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz.isInterface() ? Object.class : clazz);
        enhancer.setCallback(callback);
        return (T) enhancer.create();
    }
}
