package com.github.multicall.aggregators.delegates;

import com.github.multicall.grabber.MethodCall;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Wrapper that turns collection of objects into collection of method return values. Element accessors delegate to invoking methods
 * from underlying collection. This collection is read-only and backed by the original.
 *
 * @param <T> Original object type
 * @param <V> Method return value type
 */
public class DelegateCollection<T, V> extends AbstractCollection<V> {
    private MethodCall<T, V> call;
    private Collection<T> objects;

    public DelegateCollection(MethodCall<T, V> call, Collection<T> objects) {
        this.call = call;
        this.objects = objects;
    }

    @Override
    public Iterator<V> iterator() {
        return new DelegateIterator<T, V>(objects.iterator(), call);
    }

    @Override
    public int size() {
        return objects.size();
    }
}
