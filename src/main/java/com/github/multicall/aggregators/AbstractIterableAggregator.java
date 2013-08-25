package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;
import com.github.multicall.util.Callable;

/**
 * Superclass for 'instance utility' type aggregators that operate on collections.
 * This allows to avoid duplicated error-handling in the end-user method implementations by using CallUtil
 */
public abstract class AbstractIterableAggregator<T, V, U extends Iterable<? extends T>, R> implements Callable<R> {
    protected final U objects;
    protected final MethodCall<T, V> call;

    /**
     * Creates new instance.
     * @param objects collection of objects to operate on
     * @param call method call
     */
    public AbstractIterableAggregator(U objects, MethodCall<T, V> call) {
        this.call = call;
        this.objects = objects;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "objects=" + objects +
                ", call=" + call +
                '}';
    }
}
