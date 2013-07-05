package com.github.multicall;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Provides functionality to spawn new aggregators using enchancer
 */
public class AbstractAggregator<T> {
    protected Class<T> clazz;

    public AbstractAggregator(Class<T> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    protected T spawn(MethodInterceptor callback) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz.isInterface() ? Object.class : clazz);
        enhancer.setCallback(callback);
        return (T) enhancer.create();
    }
}
