package com.github.multicall.aggregators;

import com.github.multicall.grabber.MethodCall;

/**
 * Superclass for 'instance utility' type aggregators that operate on collections.
 * This allows to avoid duplicated error-handling in the end-user method implementations by using CallUtil
 * @deprecated use AbstractArrayAggregator instead.
 * TODO Rewrite inheritors and delete this class
 */
public abstract class AbstractIterableAggregator<T, V, U extends Iterable<? extends T>> extends AbstractAggregator<T,V> {
    protected final U objects;

    /**
     * Creates new instance.
     * @param objects collection of objects to operate on
     * @param call method call
     */
    public AbstractIterableAggregator(U objects, MethodCall<T, V> call) {
        super(call);
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
