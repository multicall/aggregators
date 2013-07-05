package com.github.multicall.aggregators;

import com.github.multicall.AbstractAggregator;
import com.github.multicall.aggregators.impl.InvokeInterceptor;
import com.github.multicall.aggregators.impl.MaxInterceptor;

/**
 * This type of aggregator provides methods that have return type exactly matching return type of method they use.
 *
 * @param <T> Class of the objects to aggregate
 */
public class Aggregator<T> extends AbstractAggregator<T> {
    Aggregator(Class<T> clazz) {
        super(clazz);
    }

    public T all(Iterable<T> iterable) {
        return spawn(new InvokeInterceptor<T>(iterable));
    }

    public T max(Iterable<T> iterable) {
        return spawn(new MaxInterceptor<T>(iterable));
    }

}
