package com.github.multicall.aggregators.stub;

import com.github.multicall.AbstractAggregator;
import com.github.multicall.aggregators.stub.interceptor.InvokeInterceptor;
import com.github.multicall.aggregators.stub.interceptor.MaxInterceptor;
import com.github.multicall.util.ArrayIteratorWrapper;

/**
 * This type of aggregator provides methods that return various 'stubs' that formally belong to the specified class.
 * This puts a limitation of having return value type for aggregated method to be same as original one, but allows
 * this aggregator to be stateless as thread safe and allows a very brief invocation syntax.
 *
 * @param <T> Class of the objects to aggregate
 */
public class StubAggregator<T> extends AbstractAggregator<T> {
    public StubAggregator(Class<T> clazz) {
        super(clazz);
    }

    public T all(T... array) {
        return all(new ArrayIteratorWrapper<T>(array));
    }

    public T all(Iterable<T> iterable) {
        return spawn(new InvokeInterceptor<T>(iterable));
    }

    public T max(T... array) {
        return max(new ArrayIteratorWrapper<T>(array));
    }

    public T max(Iterable<T> iterable) {
        return spawn(new MaxInterceptor<T>(iterable));
    }

}
