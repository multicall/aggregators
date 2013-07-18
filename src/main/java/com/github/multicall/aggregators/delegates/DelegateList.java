package com.github.multicall.aggregators.delegates;

import com.github.multicall.grabber.MethodCall;

import java.util.AbstractList;
import java.util.List;

/**
 * Wrapper that turns list of objects into a list of method return values. Element accessors delegate to invoking methods
 * from underlying collection. This list is read-only and backed by the original collection.
 *
 * @param <T> Original object type
 * @param <V> Method return value type
 */
public class DelegateList<T, V> extends AbstractList<V> {
    private MethodCall<T, V> call;
    private List<T> objects;

    public DelegateList(MethodCall<T, V> call, List<T> objects) {
        this.objects = objects;
        this.call = call;
    }

    @Override
    public V get(int index) {
        return call.replayUnsafe(objects.get(index));
    }

    @Override
    public int size() {
        return objects.size();
    }
}

