package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;

/**
 * TODO merge with AbstractArrayAggregator
 */
public class AbstractAggregator<T, V> {
    protected final MethodCall<T, V> call;

    public AbstractAggregator(MethodCall<T, V> call) {
        this.call = call;
    }
}
