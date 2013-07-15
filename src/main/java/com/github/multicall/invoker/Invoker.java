package com.github.multicall.invoker;

import com.github.multicall.AbstractAggregator;
import com.github.multicall.util.ArrayIteratorWrapper;

/**
 * Provides methods that return various 'stubs' that formally belong to the specified class but wrap a collection,
 * allowing to use a single method call to invoke the method on all collection elements.
 *
 * Instances are immutable and thread safe. Returned wrapper stubs are not thread safe.
 *
 * @param <T> Class of the objects to aggregate
 */
public class Invoker<T> extends AbstractAggregator<T> {
    public Invoker(Class<T> clazz) {
        super(clazz);
    }

    public static <T> Invoker<T> create(Class<T> clazz) {
        return new Invoker<T>(clazz);
    }

    /**
     * Wraps array into a stub that will delegate method calls on it to all nested elements.
     * Returned stubs are NOT THREAD SAFE.
     *
     * @param array Array to wrap
     * @return Wrapper stub
     */
    public T all(T... array) {
        return all(new ArrayIteratorWrapper<T>(array));
    }

    /**
     * Wraps iterable into a stub that will delegate method calls on it to all nested elements.
     * Returned stubs are NOT THREAD SAFE.
     *
     * @param iterable Iterable to wrap
     * @return Wrapper stub
     */
    public T all(Iterable<T> iterable) {
        return spawn(new InvokeInterceptor<T>(iterable));
    }

}
