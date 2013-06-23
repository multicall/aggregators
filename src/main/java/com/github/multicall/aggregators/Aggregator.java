package com.github.multicall.aggregators;

import com.github.multicall.aggregators.impl.MaxInterceptor;
import net.sf.cglib.proxy.Enhancer;

public class Aggregator<T> {
    private Class<T> clazz;

    public Aggregator(Class<T> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    T max(Iterable<T> iterable) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz.isInterface() ? Object.class : clazz);
        enhancer.setCallback(new MaxInterceptor<T>(iterable));
        return (T) enhancer.create();
    }
}
