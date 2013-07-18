package com.github.multicall.aggregators.delegates;

import com.github.multicall.grabber.MethodCall;

import java.util.Iterator;

/**
 * Wrapper that turns Iterable of objects into Iterable of method return values. Element accessors delegate to invoking methods
 * from underlying collection. This iterable is read-only and backed by the original.
 *
 * @param <T> Original object type
 * @param <V> Method return value type
 */
public class DelegateIterable<T, V> implements Iterable<V> {
    private MethodCall<T, V> call;
    private Iterable<T> objects;

    public DelegateIterable(MethodCall<T, V> call, Iterable<T> objects) {
        this.objects = objects;
        this.call = call;
    }

    @Override
    public Iterator<V> iterator() {
        return new DelegateIterator<T, V>(objects.iterator(), call);
    }
}
